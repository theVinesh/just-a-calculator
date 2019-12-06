package app.vineshbuilds.justacalculator.ui.main.buttons

import app.vineshbuilds.justacalculator.ui.main.components.IDisplay

abstract class ActOnDisplayButtonVm(
    symbol: String,
    private val display: IDisplay,
    private val onClick: (display: IDisplay) -> Unit
) : ButtonVm(symbol) {
    override fun onClick() = onClick.invoke(display)
}