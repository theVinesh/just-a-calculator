package app.vineshbuilds.justacalculator.ui.main.buttons

class ActionButtonVm(
    symbol: String, private val onClick: () -> Unit
) : ButtonVm(symbol) {
    override fun onClick() = onClick.invoke()
}