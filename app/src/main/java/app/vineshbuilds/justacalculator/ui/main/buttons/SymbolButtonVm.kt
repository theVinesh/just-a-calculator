package app.vineshbuilds.justacalculator.ui.main.buttons

import app.vineshbuilds.justacalculator.ui.main.components.IDisplay

class SymbolButtonVm(value: String, private val display: IDisplay) : ButtonVm(value) {
    override fun onClick() = display.append(value)
}