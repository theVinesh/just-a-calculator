package app.vineshbuilds.justacalculator.ui.main.buttons

import app.vineshbuilds.justacalculator.ui.main.components.IDisplay

class SymbolButtonVm(value: String, display: IDisplay) :
    ActOnDisplayButtonVm(value, display, { it.append(value) })