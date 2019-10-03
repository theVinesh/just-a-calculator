package app.vineshbuilds.calculator.tokens

class Operand(symbol: String) : Token(symbol) {
    val doubleValue = symbol.toDoubleOrNull()
}