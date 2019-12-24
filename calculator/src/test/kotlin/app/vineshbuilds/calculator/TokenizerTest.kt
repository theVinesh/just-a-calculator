package app.vineshbuilds.calculator

import org.junit.After
import org.junit.Before
import org.junit.Test

class TokenizerTest {
    private var objectUndertest: TokenizerImpl? = null

    @Before
    fun setUp() {
        objectUndertest = TokenizerImpl()
    }

    @After
    fun tearDown() {
        objectUndertest = null
    }

    @Test
    fun tokenize__simple_valid_input() {
        val infixNotation = "11-2+7"
        val output = objectUndertest?.tokenize(infixNotation)

        val expectedOutput = listOf(
            "11", "-", "2", "+", "7"
        )
        assert(expectedOutput.size == output?.size) {
            "Expected no.of token did not match\n expected : $expectedOutput\n actual : $output"
        }
        output?.forEachIndexed { index, token ->
            assert(expectedOutput[index] == token.symbol)
            {
                "index: $index expected to be '${expectedOutput[index]}' but is '$token'\n" +
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
            assert(expectedOutput[index] == token.symbol)
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