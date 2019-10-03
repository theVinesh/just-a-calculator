package app.vineshbuilds.justacalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.vineshbuilds.justacalculator.ui.main.MainFragment
import app.vineshbuilds.justacalculator.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            replaceFragment(supportFragmentManager) {
                MainFragment.newInstance()
            }
        }
    }
}
