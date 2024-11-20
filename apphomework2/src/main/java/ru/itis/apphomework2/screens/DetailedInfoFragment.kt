package ru.itis.apphomework2.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import ru.itis.apphomework2.R
import ru.itis.apphomework2.databinding.FragmentDetailBinding
import ru.itis.apphomework2.model.ListDetailedData
import ru.itis.apphomework2.repository.ScreensDetailedContentRepo

class DetailedInfoFragment(): Fragment(R.layout.fragment_detail) {

    private var viewBinding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentDetailBinding.inflate(layoutInflater)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    fun initViews() {
        val url = arguments?.getString(ARG_URL)
        val title = arguments?.getString(ARG_TITLE)
        val des = arguments?.getString(ARG_DES)


        viewBinding?.detailIv?.let { it1 ->
            Glide.with(this)
                .load(url)
                .into(it1)
        }
        viewBinding?.headerTv?.text = title.toString()
        viewBinding?.desTv?.text = des.toString()


    }

    companion object {
        const val TAG = "detailed_screen_fragment"
        const val ARG_URL = "string_url"
        const val ARG_TITLE = "string_title"
        const val ARG_DES = "string_des"

        fun getInstance(
            paramUrl: String,
            paramTitle : String,
            paramDes : String
        ): DetailedInfoFragment {
            return DetailedInfoFragment().apply {
                arguments = bundleOf(ARG_URL to paramUrl, ARG_TITLE to paramTitle, ARG_DES to paramDes)
            }
        }
    }
}