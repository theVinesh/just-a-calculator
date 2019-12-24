package app.vineshbuilds.calculator.tokens

sealed class BinaryOperator(
    symbol: String, weight: Int,
    private val operate: (a: Double, b: Double) -> Double
) : Operator(symbol, weight) {

    object Add : BinaryOperator("+", WEIGHT_ADD_SUB, { a, b -> a + b })

    object Sub : BinaryOperator("-", WEIGHT_ADD_SUB, { a, b -> b - a })

    object Mul : BinaryOperator("*", WEIGHT_MUL_DIV, { a, b -> a * b })

    object Div : BinaryOperator("/", WEIGHT_MUL_DIV, { a, b -> b / a })

    object Mod : BinaryOperator("%", WEIGHT_MUL_DIV, { a, b -> b % a })

    override fun operate(vararg operands: Double): Double {
        check(operands.size == 2) { "Binary Operator operates on exactly 2 operands" }
        return operate.invoke(operands[0], operands[1])
    }

    companion object {
        private const val WEIGHT_ADD_SUB = 1
        private const val WEIGHT_MUL_DIV = 2
    }
}