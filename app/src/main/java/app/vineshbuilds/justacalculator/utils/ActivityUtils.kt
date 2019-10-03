package app.vineshbuilds.justacalculator.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import app.vineshbuilds.justacalculator.R

fun replaceFragment(fragmentManager: FragmentManager, fragmentCreator: () -> Fragment) {
    val fragment = fragmentCreator.invoke()
    fragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
}