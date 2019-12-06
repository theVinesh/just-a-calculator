package app.vineshbuilds.justacalculator.ui.main.buttons

import androidx.lifecycle.ViewModel

abstract class ButtonVm(val value: String) : ViewModel(){
    abstract fun onClick()
}

