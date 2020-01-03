package app.vineshbuilds.justacalculator.ui.main.components

import androidx.lifecycle.ViewModel
import app.vineshbuilds.calculator.IProcessor
import app.vineshbuilds.justacalculator.ui.main.buttons.ActionButtonVm
import app.vineshbuilds.justacalculator.ui.main.buttons.SymbolButtonVm

class KeypadVm(display: IDisplay, processor: IProcessor) : ViewModel() {

    val operands = arrayOf(
        SymbolButtonVm("0", display),
        SymbolButtonVm("1", display),
        SymbolButtonVm("2", display),
        SymbolButtonVm("3", display),
        SymbolButtonVm("4", display),
        SymbolButtonVm("5", display),
        SymbolButtonVm("6", display),
        SymbolButtonVm("7", display),
        SymbolButtonVm("8", display),
        SymbolButtonVm("9", display)
    )
    val operators = arrayOf(
        SymbolButtonVm("+", display),
        SymbolButtonVm("-", display),
        SymbolButtonVm("/", display),
        SymbolButtonVm("*", display),
        ActionButtonVm("=") {
            with(display) {
                set(processor.solve(get()).toString())
            }
        }
    )
    val decimal = SymbolButtonVm(".", display)
    val delete = ActionButtonVm("DEL") { display.delete() }
}