package app.vineshbuilds.justacalculator.ui.main.components

import androidx.lifecycle.ViewModel
import app.vineshbuilds.justacalculator.ui.main.buttons.ActionOnDisplayButtonVm
import app.vineshbuilds.justacalculator.ui.main.buttons.NumberButtonVm
import app.vineshbuilds.justacalculator.ui.main.buttons.SymbolButtonVm

class KeypadVm(display: IDisplay) : ViewModel() {

    val operands = arrayOf(
        NumberButtonVm(0, display),
        NumberButtonVm(1, display),
        NumberButtonVm(2, display),
        NumberButtonVm(3, display),
        NumberButtonVm(4, display),
        NumberButtonVm(5, display),
        NumberButtonVm(6, display),
        NumberButtonVm(7, display),
        NumberButtonVm(8, display),
        NumberButtonVm(9, display)
    )
    val decimal = SymbolButtonVm(".", display)
    val delete = ActionOnDisplayButtonVm("DEL", display) {
        it.delete()
    }
}