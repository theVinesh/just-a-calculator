package app.vineshbuilds.calculator.tokens

object Operators {

    const val WEIGHT_ADD_SUB = 1
    const val WEIGHT_MUL_DIV = 2

    fun getOperatorFor(symbol: String): Operator = symbolOperatorMap[symbol]
        ?: throw NoSuchElementException("No operator with $symbol is defined")

    fun isOperator(symbol: String) = symbolOperatorMap.keys.contains(symbol)

    private val symbolOperatorMap = mapOf(
        "+" to Add,
        "-" to Sub,
        "*" to Mul,
        "/" to Div,
        "%" to Mod
    )

    //All operator definitions go here

    object Add : BinaryOperator("+", WEIGHT_ADD_SUB, { a, b -> a + b })

    object Sub : BinaryOperator("-", WEIGHT_ADD_SUB, { a, b -> b - a })

    object Mul : BinaryOperator("*", WEIGHT_MUL_DIV, { a, b -> a * b })

    object Div : BinaryOperator("/", WEIGHT_MUL_DIV, { a, b -> b / a })

    object Mod : BinaryOperator("%", WEIGHT_MUL_DIV, { a, b -> b % a })
}

abstract class BinaryOperator(
    symbol: String, weight: Int,
    private val operate: (a: Double, b: Double) -> Double
) : Operator(symbol, weight) {

    override fun operate(vararg operands: Double): Double {
        check(operands.size == 2) { "Binary Operator operates on exactly 2 operands" }
        return operate.invoke(operands[0], operands[1])
    }
}