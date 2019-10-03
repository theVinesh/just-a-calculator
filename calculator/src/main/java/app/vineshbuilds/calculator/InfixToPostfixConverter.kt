package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.tokens.Operand
import app.vineshbuilds.calculator.tokens.Operator
import app.vineshbuilds.calculator.tokens.Operators
import app.vineshbuilds.calculator.tokens.Token
import java.util.*

class InfixToPostfixConverter {

    fun convertToPostfix(infixNotation: String): Stack<Token> {
        val infixTokens = tokenize(infixNotation)
        val postfixTokens = Stack<Token>()
        val operatorStack = Stack<Operator>()
        infixTokens.forEach {
            if (Operators.isOperator(it)) {
                val operator = Operators.get(it)
                if (operatorStack.isEmpty() || operator.weight >= operatorStack.peek().weight) {
                    operatorStack.push(operator)
                } else {
                    while (
                        operatorStack.isNotEmpty() && operatorStack.peek().weight > operator.weight
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

    fun tokenize(infixNotation: String): List<String> {
        val tokens = mutableListOf<String>()
        val stringBuilder = StringBuilder()

        fun flushIntoList() {
            if (stringBuilder.isNotBlank()) {
                tokens.add(stringBuilder.toString())
                stringBuilder.clear()
            }
        }

        infixNotation.toCharArray().forEach {
            when (it) {
                '+', '*', '/' -> {
                    flushIntoList()
                    tokens.add("$it")
                }
                '-' -> {
                    flushIntoList()
                    if (tokens.lastOrNull()?.toDoubleOrNull() != null) {
                        tokens.add("$it")
                    } else {
                        stringBuilder.append(it)
                    }
                }
                else -> stringBuilder.append(it)

            }
        }
        flushIntoList()
        return tokens
    }
}
