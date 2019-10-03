package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.tokens.BinaryOperator
import app.vineshbuilds.calculator.tokens.Operand
import app.vineshbuilds.calculator.tokens.Token
import java.util.*

class Processor {

    fun solve(postfixStack: Stack<Token>): Double =
        if (postfixStack.isNotEmpty()) when (val token = postfixStack.pop()) {
            is Operand -> token.doubleValue
                ?: throw IllegalStateException("Cannot convert ${token.symbol} to Double")
            is BinaryOperator -> token.operate(solve(postfixStack), solve(postfixStack))
            else -> throw IllegalStateException("Unknown token $token")
        }
        else 0.0

}