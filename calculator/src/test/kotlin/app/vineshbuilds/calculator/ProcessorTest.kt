package app.vineshbuilds.calculator

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ProcessorTest {
    lateinit var tokenizer: ITokenizer
    private var objectUnderTest: Processor? = null

    @Before
    fun setUp() {
        tokenizer = Mockito.mock(ITokenizer::class.java)
        objectUnderTest = Processor(tokenizer)
    }

    @After
    fun tearDown() {
        objectUnderTest = null
    }


    @Test
    fun solve() {
        val input = "15+-23*18.01-2/7"
        Mockito.`when`(tokenizer.tokenize(input)).thenReturn(
            listOf("15", "+", "-23", "*", "18.01", "-", "2", "/", "7")
        )
        val output = objectUnderTest?.solve(input)
        assert(output == -399.5157142857143) {
            "Expected -399.5157142857 actual $output\n"
        }
    }

    @Test
    fun convert__simple_valid_input() {
        val input = "11-2+7"
        Mockito.`when`(tokenizer.tokenize(input)).thenReturn(
            listOf("11", "-", "2", "+", "7")
        )
        val output = objectUnderTest?.convertToPostfix(input)

        val expectedOutput = listOf(
            "11", "2", "-", "7", "+"
        )
        assert(expectedOutput.size == output?.size) {
            "Expected no.of token did not match"
        }
        output?.forEachIndexed { index, token ->
            assert(expectedOutput[index] == token.symbol)
            {
                "index: '$index' expected to be '${expectedOutput[index]}' but is '$token'\n" +
                        "expected : $expectedOutput\n actual : $output"
            }
        }
    }

    @Test
    fun convert__valid_input() {
        val input = "15+-23*18.01-2/7"

        Mockito.`when`(tokenizer.tokenize(input)).thenReturn(
            listOf("15", "+", "-23", "*", "18.01", "-", "2", "/", "7")
        )

        val output = objectUnderTest?.convertToPostfix(input)

        val expectedOutput = listOf(
            "15", "-23", "18.01", "*", "+", "2", "7", "/", "-"
        )
        assert(expectedOutput.size == output?.size) {
            "Expected no.of token did not match\n" +
                    "expected : $expectedOutput\nactual : $output"
        }
        output?.forEachIndexed { index, token ->
            assert(expectedOutput[index] == token.symbol)
            {
                "index: '$index' expected to be '${expectedOutput[index]}' but is '$token'\n" +
                        "expected : $expectedOutput\n actual : $output"
            }
        }
    }

}