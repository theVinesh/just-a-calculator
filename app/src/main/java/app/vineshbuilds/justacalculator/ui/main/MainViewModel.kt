package app.vineshbuilds.justacalculator.ui.main

import androidx.lifecycle.ViewModel
import app.vineshbuilds.calculator.ITokenizer
import app.vineshbuilds.calculator.Processor
import app.vineshbuilds.calculator.TokenizerImpl
import app.vineshbuilds.justacalculator.ui.main.components.DisplayVm
import app.vineshbuilds.justacalculator.ui.main.components.KeypadVm

class MainViewModel : ViewModel() {

    val display = DisplayVm()
    val keypad = KeypadVm(display)

    private val tokenizer: ITokenizer = TokenizerImpl()

    private val processor = Processor(tokenizer)

    fun equals() = with(display) { set("${processor.solve(get())}") }
}
