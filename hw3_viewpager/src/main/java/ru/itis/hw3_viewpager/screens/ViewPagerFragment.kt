package ru.itis.hw3_viewpager.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.itis.hw3_viewpager.R
import ru.itis.hw3_viewpager.adapter.ViewPagerAdapter
import ru.itis.hw3_viewpager.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private var viewBinding : FragmentViewPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(
            manager = parentFragmentManager,
            lifecycle = this.lifecycle
        )
        viewBinding?.contentVp?.adapter = adapter

        viewBinding?.contentVp?.offscreenPageLimit = adapter.itemCount
    }


    companion object {
        const val TAG = "VIEW_PAGER_FRAGMENT_TAG"
    }
}