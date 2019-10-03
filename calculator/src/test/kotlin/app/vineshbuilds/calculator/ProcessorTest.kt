package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.tokens.Operand
import app.vineshbuilds.calculator.tokens.Operators
import app.vineshbuilds.calculator.tokens.Token
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

class ProcessorTest {
    private var objectUnderTest: Processor? = null
    lateinit var stack: Stack<Token>
    @Before
    fun setUp() {
        stack = Stack<Token>().apply {
            push(Operand("15"))
            push(Operand("-23"))
            push(Operand("18.01"))
            push(Operators.Mul)
            push(Operand("2"))
            push(Operand("7"))
            push(Operators.Div)
            push(Operators.Sub)
            push(Operators.Add)
        }
        objectUnderTest = Processor()
    }

    @After
    fun tearDown() {
        objectUnderTest = null
        stack.clear()
    }

    @Test
    fun solve() {
        val result = objectUnderTest?.solve(stack)
        assert(result == -399.5157142857143) {
            "Expected -399.5157142857 actual $result\n"
        }
    }
}