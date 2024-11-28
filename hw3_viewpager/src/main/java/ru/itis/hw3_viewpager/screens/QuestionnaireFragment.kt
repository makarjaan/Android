package ru.itis.hw3_viewpager.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import ru.itis.hw3_viewpager.R
import ru.itis.hw3_viewpager.adapter.QuestionAdapter
import ru.itis.hw3_viewpager.databinding.FragmentQuestionnaireBinding
import ru.itis.hw3_viewpager.repository.ScreensContentRepo
class QuestionnaireFragment : Fragment(R.layout.fragment_questionnaire) {

    private var viewBinding: FragmentQuestionnaireBinding? = null
    private lateinit var viewPager: ViewPager2
    private var rvAdapter: QuestionAdapter? = null
    private val answersState = MutableList(10) { false }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentQuestionnaireBinding.inflate(inflater, container, false)
        viewPager = requireActivity().findViewById(R.id.content_vp)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    fun initViews() {
        arguments?.getInt(POSITION_KEY)?.let { position ->
            val list = ScreensContentRepo().getInfo(position)
            viewBinding?.apply {
                questTv.text = list.question
                questHumberTv.text = "${list.id}/10"
            }

            rvAdapter = QuestionAdapter(
                action = { position -> onItemClick(position) },
                items = list.answers!!
            )
            viewBinding?.mainRv?.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rvAdapter
            }

            val itemCount = viewPager.adapter?.itemCount
            if (position == 0) {
                viewBinding?.button1?.isEnabled = false
            }

            if (itemCount != null) {
                if (position == itemCount - 1) {
                    viewBinding?.button2?.text = getString(R.string.end_text)
                }
            }

            if (answersState.all { it }) {
                viewBinding?.button2?.isEnabled = true
            }

            viewBinding?.button2?.setOnClickListener {
                if (itemCount != null) {
                    if (position < itemCount - 1) {
                        viewPager.setCurrentItem(position + 1, true)
                    } else {
                        Snackbar.make(requireView(), getString(R.string.thanks), Snackbar.LENGTH_LONG).show()
                        viewBinding?.button2?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))

                    }
                }
            }

            viewBinding?.button1?.setOnClickListener{
                if (position > 0) {
                    viewPager.setCurrentItem(position- 1, true)
                }
            }
        }
    }

    fun onItemClick(position: Int) {
        rvAdapter?.updateSelection(
            ContextCompat.getColor(requireContext(), R.color.white),
            ContextCompat.getColor(requireContext(), R.color.newGreen),
            R.drawable.ic_is_not_answer,
            R.drawable.ic_is_answer,
            position
        )
    }

    companion object {
        private const val POSITION_KEY = "POSITION"

        fun getInstance(position: Int) = QuestionnaireFragment().apply {
            arguments = bundleOf(POSITION_KEY to position)
        }
    }
}
