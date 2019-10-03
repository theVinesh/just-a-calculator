package app.vineshbuilds.justacalculator.ui.main

import androidx.lifecycle.ViewModel
import app.vineshbuilds.calculator.InfixToPostfixConverter
import app.vineshbuilds.calculator.Processor

class MainViewModel : ViewModel() {

    private val converter = InfixToPostfixConverter()
    private val processor = Processor()

    fun equals(input: String): String {
        val postfixStack = converter.convertToPostfix(input.trim())
        val result = processor.solve(postfixStack)
        return "$result"
    }
}
