package app.vineshbuilds.calculator.tokens

abstract class Operator(symbol: String, val weight: Int) : Token(symbol) {

    abstract fun operate(vararg operands: Double): Double
}