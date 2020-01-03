package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.operators.BinaryOperator
import app.vineshbuilds.calculator.operators.UnaryOperator
import app.vineshbuilds.calculator.tokens.Operand
import app.vineshbuilds.calculator.tokens.Operator
import app.vineshbuilds.calculator.tokens.Token
import java.util.*

class ProcessorImpl(private val tokenizer: ITokenizer) : IProcessor {

    fun convertToPostfix(infixNotation: String): Stack<Token> {
        val infixTokens = tokenizer.tokenize(infixNotation)
        val postfixTokens = Stack<Token>()
        val operatorStack = Stack<Operator>()
        infixTokens.forEach {
            when (it) {
                is Operator -> {
                    if (operatorStack.isEmpty() || it.weight > operatorStack.peek().weight) {
                        operatorStack.push(it)
                    } else {
                        while (
                            operatorStack.isNotEmpty() && operatorStack.peek().weight >= it.weight
                        ) {
                            postfixTokens.push(operatorStack.pop())
                        }
                        operatorStack.push(it)
                    }
                }
                is Operand -> {
                    postfixTokens.push(it)
                }
            }
        }
        while (operatorStack.isNotEmpty()) {
            postfixTokens.push(operatorStack.pop())
        }
        return postfixTokens
    }

    override fun solve(infixNotation: String): Double = solve(convertToPostfix(infixNotation))

    @Throws(IllegalStateException::class)
    private fun solve(postfixStack: Stack<Token>): Double =
        if (postfixStack.isNotEmpty()) when (val token = postfixStack.pop()) {
            is Operand -> token.doubleValue
                ?: throw IllegalStateException("Cannot convert ${token.symbol} to Double")
            is BinaryOperator -> token.operate(solve(postfixStack), solve(postfixStack))
            is UnaryOperator -> token.operate(solve(postfixStack))
            else -> throw IllegalStateException("Unknown token $token")
        }
        else 0.0
}