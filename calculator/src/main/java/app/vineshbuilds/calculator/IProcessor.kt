package app.vineshbuilds.calculator

interface IProcessor {
    fun solve(infixNotation: String): Double
}