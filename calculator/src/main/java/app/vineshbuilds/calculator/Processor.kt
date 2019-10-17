package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.tokens.*
import java.util.*

class Processor(private val tokenizer: ITokenizer) {

    fun convertToPostfix(infixNotation: String): Stack<Token> {
        val infixTokens = tokenizer.tokenize(infixNotation)
        val postfixTokens = Stack<Token>()
        val operatorStack = Stack<Operator>()
        infixTokens.forEach {
            if (Operators.isOperator(it)) {
                val operator = Operators.getOperatorFor(it)
                if (operatorStack.isEmpty() || operator.weight > operatorStack.peek().weight) {
                    operatorStack.push(operator)
                } else {
                    while (
                        operatorStack.isNotEmpty() && operatorStack.peek().weight >= operator.weight
                    ) {
                        postfixTokens.push(operatorStack.pop())
                    }
                    operatorStack.push(operator)
                }
            } else {
                postfixTokens.push(Operand(it))
            }
        }
        while (operatorStack.isNotEmpty()) {
            postfixTokens.push(operatorStack.pop())
        }
        return postfixTokens
    }

    fun solve(infixNotation: String): Double = solve(convertToPostfix(infixNotation))

    private fun solve(postfixStack: Stack<Token>): Double =
        if (postfixStack.isNotEmpty()) when (val token = postfixStack.pop()) {
            is Operand -> token.doubleValue
                ?: throw IllegalStateException("Cannot convert ${token.symbol} to Double")
            is BinaryOperator -> token.operate(solve(postfixStack), solve(postfixStack))
            else -> throw IllegalStateException("Unknown token $token")
        }
        else 0.0

}