package app.vineshbuilds.calculator.tokens

abstract class Token(val symbol: String) {
    override fun toString() = symbol
    fun isOperator(): Boolean {
        return OPERATORS.keys.contains(symbol)
    }
}