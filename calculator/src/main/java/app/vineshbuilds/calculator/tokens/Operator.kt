package app.vineshbuilds.calculator.tokens


abstract class Operator(symbol: String, token: String, internal val weight: Int) : Token(token) {
    abstract fun operate(vararg operands: Double): Double
}