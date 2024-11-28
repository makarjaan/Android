package ru.itis.hw3_viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.itis.hw3_viewpager.databinding.ActivityMainBinding
import ru.itis.hw3_viewpager.screens.ViewPagerFragment


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
                    ViewPagerFragment(),
                    ViewPagerFragment.TAG
                ).commit()
            }
        }
    }

    override fun onDestroy() {
        viewBinding = null
        super.onDestroy()
    }
}