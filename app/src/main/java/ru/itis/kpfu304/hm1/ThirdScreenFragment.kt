package ru.itis.kpfu304.hm1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.itis.kpfu304.R
import ru.itis.kpfu304.databinding.FragmentSecondScreenBinding
import ru.itis.kpfu304.databinding.FragmentThirdScreenBinding
import ru.itis.kpfu304.hm1.SecondScreenFragment.Companion


class ThirdScreenFragment : Fragment(R.layout.fragment_third_screen) {

    private var viewBinding : FragmentThirdScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputText = arguments?.getString(ARG_KEY)
        viewBinding?.secondFragmentTv?.text = inputText
    }


    companion object {
        const val TAG = "third_screen_fragment"

        private const val ARG_KEY = "ARG_TEXT"

        fun getInstance(
            param1: String
        ): ThirdScreenFragment {
            return ThirdScreenFragment().apply {
                arguments = bundleOf(ARG_KEY to param1)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}