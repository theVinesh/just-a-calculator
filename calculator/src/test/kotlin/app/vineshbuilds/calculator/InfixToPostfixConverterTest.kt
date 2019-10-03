package app.vineshbuilds.calculator


import org.junit.After
import org.junit.Before
import org.junit.Test

internal class InfixToPostfixConverterTest {
//-399.5157142857
    private var objectUndertest: InfixToPostfixConverter? = null

    @Before
    fun setUp() {
        objectUndertest = InfixToPostfixConverter()
    }

    @After
    fun tearDown() {
        objectUndertest = null
    }

    @Test
    fun convert() {
        val infixNotation = "15+-23*18.01-2/7"
        val output = objectUndertest?.convertToPostfix(infixNotation)

        val expectedOutput = listOf(
            "15", "-23", "18.01", "*", "2", "7", "/", "-", "+"
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
    fun tokenize__valid_input() {
        val infixNotation = "15+-23*18.01-2/7"
        val output = objectUndertest?.tokenize(infixNotation)

        val expectedOutput = listOf(
            "15", "+", "-23", "*", "18.01", "-", "2", "/", "7"
        )
        assert(expectedOutput.size == output?.size) {
            "Expected no.of token did not match\n expected : $expectedOutput\n actual : $output"
        }
        output?.forEachIndexed { index, token ->
            assert(expectedOutput[index] == token)
            {
                "index: $index expected to be '${expectedOutput[index]}' but is '$token'\n" +
                        "expected : $expectedOutput\n actual : $output"
            }
        }
    }

    @Test
    fun tokenize__when_input_is_empty() {
        val infixNotation = ""
        val output = objectUndertest?.tokenize(infixNotation)

        assert(0 == output?.size) {
            "Empty input should yield empty list"
        }

    }
}