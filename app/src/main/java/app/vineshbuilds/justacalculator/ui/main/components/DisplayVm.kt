package app.vineshbuilds.justacalculator.ui.main.components

import androidx.lifecycle.ViewModel
import app.vineshbuilds.justacalculator.utils.ObservableString

class DisplayVm : ViewModel(), IDisplay {
    val input = ObservableString("0")

    override fun get() = input.get()

    override fun set(value: String) = input.set(value)

    override fun append(value: String) = with(input) {
        get().let { set(if (it.isBlank() || it.toDouble() == 0.0) value else it + value) }
    }

    override fun delete() = with(input) {
        get().let {
            if (it.isNotBlank()) {
                set(it.substring(0, it.length - 1))
            }
        }
    }

    override fun clear() = input.set("0")
}