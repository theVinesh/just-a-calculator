package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.operators.BinaryOperator
import app.vineshbuilds.calculator.tokens.Operand
import app.vineshbuilds.calculator.tokens.Token
import app.vineshbuilds.calculator.operators.UnaryOperator

class TokenizerImpl : ITokenizer {

    override fun tokenize(infixNotation: String): List<Token> {
        val tokens = mutableListOf<Token>()
        val stringBuilder = StringBuilder()

        fun pushOperandAndClearBuffer() {
            if (stringBuilder.isNotBlank()) {
                tokens.add(Operand(stringBuilder.toString()))
                stringBuilder.clear()
            }
        }

        infixNotation.toCharArray().forEach {
            when (it) {
                ADD.first, MUL.first, DIV.first, MOD.first, NEG.first -> {
                    pushOperandAndClearBuffer()
                    if (NEG.first == it) {
                        if (tokens.isEmpty() || tokens.last().isOperator()) {
                            tokens.add((UnaryOperator.Negation))
                        } else {
                            tokens.add(BinaryOperator.Sub)
                        }
                    } else {
                        tokens.add(getOperatorFor(it))
                    }
                }
                else -> stringBuilder.append(it)
            }
        }
        pushOperandAndClearBuffer()
        return tokens
    }
}