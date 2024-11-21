package ru.itis.apphomework2.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.itis.apphomework2.R
import ru.itis.apphomework2.databinding.DialogBottomSheetBinding
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.model.ListRecycleMainData
import ru.itis.apphomework2.repository.ScreensContentRepository
import kotlin.random.Random

class BottomSheetFragment: BottomSheetDialogFragment(R.layout.dialog_bottom_sheet) {

    private var viewBinding : DialogBottomSheetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogBottomSheetBinding.inflate(layoutInflater)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding?.run {
            bottomEd.addTextChangedListener {

                val editText = bottomEd.text.toString()

                bottomFirstBtn.setOnClickListener {
                    if ((editText.toIntOrNull() != null)) {
                        (requireParentFragment() as? MultipleTypesFragment)?.addRandomItems(editText.toInt())
                    } else {
                        Toast.makeText(context, "Введите число!", Toast.LENGTH_SHORT).show()
                    }
                    dismiss()
                }


                bottomSecondBtn.setOnClickListener {
                    if ((editText.toIntOrNull() != null)) {
                        (requireParentFragment() as? MultipleTypesFragment)?.deleteRandomItems(editText.toInt())
                    } else {
                        Toast.makeText(context, "Введите число!", Toast.LENGTH_SHORT).show()
                    }
                    dismiss()
                }
            }

            bottomThirdBtn.setOnClickListener {
                (requireParentFragment() as? MultipleTypesFragment)?.addRandomElem()
                dismiss()
            }

            bottomFourthBtn.setOnClickListener {
                (requireParentFragment() as? MultipleTypesFragment)?.deleteRandomElem()
                dismiss()
            }

        }
    }

    companion object {
        const val TAG = "bottom_sheet"
    }
}