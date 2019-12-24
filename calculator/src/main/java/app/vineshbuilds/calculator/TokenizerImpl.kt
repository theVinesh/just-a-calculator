package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.tokens.BinaryOperator.Sub
import app.vineshbuilds.calculator.tokens.Operand
import app.vineshbuilds.calculator.tokens.Token
import app.vineshbuilds.calculator.tokens.getOperatorFor

class TokenizerImpl : ITokenizer {

    override fun tokenize(infixNotation: String): List<Token> {
        val tokens = mutableListOf<Token>()
        val stringBuilder = StringBuilder()

        fun flushIntoList() {
            if (stringBuilder.isNotBlank()) {
                tokens.add(stringBuilder.toString().let {
                    try {
                        getOperatorFor(it)
                    } catch (_: NoSuchElementException) {
                        Operand(it)
                    }
                })
                stringBuilder.clear()
            }
        }

        infixNotation.toCharArray().forEach {
            when (it) {
                '+', '*', '/', '%' -> {
                    flushIntoList()
                    tokens.add(getOperatorFor("$it"))
                }
                '-' -> {
                    flushIntoList()
                    if (tokens.isNotEmpty() && tokens.last().isOperator()) {
                        //negative number
                        stringBuilder.append(it)
                    } else {
                        tokens.add(Sub)
                    }
                }
                else -> stringBuilder.append(it)
            }
        }
        flushIntoList()
        return tokens
    }
}