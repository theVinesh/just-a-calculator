package app.vineshbuilds.calculator

interface ITokenizer {
    fun tokenize(infixNotation: String): List<String>
}