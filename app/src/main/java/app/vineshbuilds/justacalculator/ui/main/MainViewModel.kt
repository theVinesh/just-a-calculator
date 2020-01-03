package app.vineshbuilds.justacalculator.ui.main

import androidx.lifecycle.ViewModel
import app.vineshbuilds.calculator.IProcessor
import app.vineshbuilds.calculator.ITokenizer
import app.vineshbuilds.calculator.ProcessorImpl
import app.vineshbuilds.calculator.TokenizerImpl
import app.vineshbuilds.justacalculator.ui.main.components.DisplayVm
import app.vineshbuilds.justacalculator.ui.main.components.KeypadVm

class MainViewModel : ViewModel() {

    private val tokenizer: ITokenizer = TokenizerImpl()
    private val processor: IProcessor = ProcessorImpl(tokenizer)

    val display = DisplayVm()
    val keypad = KeypadVm(display, processor)

    fun equals() = with(display) { set("${processor.solve(get())}") }
}
