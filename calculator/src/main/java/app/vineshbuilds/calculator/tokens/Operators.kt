package app.vineshbuilds.calculator.tokens

import app.vineshbuilds.calculator.tokens.BinaryOperator.*

val OPERATORS = mapOf(
    "+" to Add,
    "-" to Sub,
    "*" to Mul,
    "/" to Div,
    "%" to Mod
)

fun getOperatorFor(symbol: String): Operator = OPERATORS[symbol]
    ?: throw NoSuchElementException("No operator with $symbol is defined")

