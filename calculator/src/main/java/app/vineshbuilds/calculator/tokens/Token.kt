package app.vineshbuilds.calculator.tokens

import app.vineshbuilds.calculator.OPERATOR_OPERATION_MAP

abstract class Token(val symbol: String) {
    override fun toString() = symbol
    fun isOperator() =
        OPERATOR_OPERATION_MAP.keys.find { (_, token) -> token == symbol } != null
}