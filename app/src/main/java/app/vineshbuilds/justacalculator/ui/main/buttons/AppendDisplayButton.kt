package app.vineshbuilds.justacalculator.ui.main.buttons

import app.vineshbuilds.justacalculator.ui.main.components.IDisplay

abstract class AppendDisplayButton(symbol: String, val display: IDisplay) : ButtonVm(symbol) {
    override fun onClick() = display.append(value)
}