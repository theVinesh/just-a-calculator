package app.vineshbuilds.justacalculator.ui.main.components

interface IDisplay {
    fun get(): String

    fun set(value: String)

    fun append(value: String)

    fun delete()

    fun clear()
}