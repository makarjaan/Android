package ru.itis.apphomework2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.itis.apphomework2.R
import ru.itis.apphomework2.databinding.ActivityMainBinding
import ru.itis.apphomework2.screens.MultipleTypesFragment


class MainActivity : AppCompatActivity() {

    private var viewBinding : ActivityMainBinding? = null

    private val containerId : Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    containerId,
                    MultipleTypesFragment(),
                    MultipleTypesFragment.TAG
                ).commit()
            }
        }
    }

    override fun onDestroy() {
        viewBinding = null
        super.onDestroy()
    }
}