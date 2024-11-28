package ru.itis.hw3_viewpager.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.itis.hw3_viewpager.screens.QuestionnaireFragment

class ViewPagerAdapter(
    manager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(manager, lifecycle) {


    override fun createFragment(position: Int): Fragment {
        return QuestionnaireFragment.getInstance(position)
    }

    override fun getItemCount(): Int = 10
}
