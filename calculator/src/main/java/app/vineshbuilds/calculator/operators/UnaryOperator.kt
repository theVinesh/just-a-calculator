package app.vineshbuilds.calculator.operators

import app.vineshbuilds.calculator.tokens.Operator

sealed class UnaryOperator(
    symbol: String, token: String, weight: Int,
    private val operate: (a: Double) -> Double
) : Operator(symbol, token, weight) {

    object Negation : UnaryOperator("-", "neg",
        WEIGHT, { a -> -a })

    override fun operate(vararg operands: Double): Double {
        check(operands.size == 1) { "Unary Operator operates on exactly 1 operand" }
        return operate.invoke(operands[0])
    }

    companion object {
        private const val WEIGHT = 3
    }
}