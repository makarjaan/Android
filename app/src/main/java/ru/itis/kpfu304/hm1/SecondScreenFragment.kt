package ru.itis.kpfu304.hm1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.itis.kpfu304.R
import ru.itis.kpfu304.databinding.FragmentFirstScreenBinding
import ru.itis.kpfu304.databinding.FragmentSecondScreenBinding
import ru.itis.kpfu304.hm1.FirstScreenFragment.Companion


class SecondScreenFragment : Fragment(R.layout.fragment_second_screen) {

    private var viewBinding : FragmentSecondScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputText = arguments?.getString(ARG_KEY)
        viewBinding?.secondFragmentTv?.text = inputText
        initViews()
    }


    private fun initViews(){
        viewBinding?.run {
            secondFragmentBtn.setOnClickListener {
                val inputText = secondFragmentTv.text.toString()
                val thirdFragment = ThirdScreenFragment.getInstance(if (inputText.isEmpty()) "Текст не был передан" else inputText)
                (requireActivity() as? MainActivity)?.replaceFragment(ThirdScreenFragment.TAG, thirdFragment)
            }
        }
    }

    companion object {
        const val TAG = "second_screen_fragment"

        private const val ARG_KEY = "ARG_TEXT"

        fun getInstance(
            param1: String
        ): SecondScreenFragment {
            return SecondScreenFragment().apply {
                arguments = bundleOf(ARG_KEY to param1)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }


}