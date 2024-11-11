package ru.itis.kpfu304.hm1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.itis.kpfu304.R
import ru.itis.kpfu304.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewBinding : ActivityMainBinding? = null

    private val containerId : Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    containerId,
                    FirstScreenFragment(),
                    FirstScreenFragment.TAG
                ).commit()
            }
        }

    }


    fun replaceFragment(tagNew: String, fragment: Fragment) {

        val newFragment = supportFragmentManager.findFragmentByTag(tagNew)

        if (newFragment != null) {
            supportFragmentManager.beginTransaction()
                .add(containerId, newFragment, tagNew)
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(containerId, fragment, tagNew)
                .addToBackStack(null)
                .commit()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}
