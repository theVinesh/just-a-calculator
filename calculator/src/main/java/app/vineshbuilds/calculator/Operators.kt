package app.vineshbuilds.calculator

import app.vineshbuilds.calculator.operators.BinaryOperator.*
import app.vineshbuilds.calculator.tokens.Operator
import app.vineshbuilds.calculator.operators.UnaryOperator.*

val ADD = Pair('+', "add")
val SUB = Pair('-', "sub")
val MUL = Pair('*', "mul")
val DIV = Pair('/', "div")
val MOD = Pair('%', "mod")
val NEG = Pair('-', "neg")

val OPERATOR_OPERATION_MAP = mapOf(
    ADD to Add,
    SUB to Sub,
    MUL to Mul,
    DIV to Div,
    MOD to Mod,
    NEG to Negation
)

fun getOperatorFor(symbol: Char): Operator =
    OPERATOR_OPERATION_MAP.entries.find { (symbolToken, _) ->
        symbolToken.first == symbol
    }?.value ?: throw NoSuchElementException("No operator with $symbol is defined")