package app.vineshbuilds.justacalculator.utils

import androidx.databinding.Observable
import androidx.databinding.ObservableField

typealias ObservableString = NonNullObservableField<String>

class NonNullObservableField<T : Any>(
    value: T, vararg dependencies: Observable
) : ObservableField<T>(*dependencies) {
    init {
        set(value)
    }

    override fun get(): T = super.get()!!

    @Suppress("RedundantOverride") // Only allow non-null `value`.
    override fun set(value: T) = super.set(value)
}