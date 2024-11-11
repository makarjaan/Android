package ru.itis.kpfu304.hm1

import android.R.attr.text
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.itis.kpfu304.R
import ru.itis.kpfu304.databinding.DialogBottomSheetBinding
import ru.itis.kpfu304.hm1.SecondScreenFragment.Companion


class BottomSheetFragment : BottomSheetDialogFragment(R.layout.dialog_bottom_sheet) {

    private var viewBinding : DialogBottomSheetBinding? = null

    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogBottomSheetBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews () {
        viewBinding?.run {
            with(bottomSheetBtn) {
                isEnabled = false
                bottomEd.addTextChangedListener {
                    val editText = bottomEd.text.toString()
                    isEnabled = editText.isNotBlank()
                    setOnClickListener {
                        if (editText.isNotEmpty()) {
                            bundle.putString(ARG_KEY, editText)
                            (requireParentFragment() as? FirstScreenFragment)?.replace(bundle)
                        }
                        dismiss()
                    }
                }
            }
        }
    }

    companion object {
        const val TAG = "BOTTOM_SHEET"
        private const val ARG_KEY = "ARG_TEXT"
    }
}