package ru.itis.kpfu304.hm1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.itis.kpfu304.R
import ru.itis.kpfu304.databinding.FragmentFirstScreenBinding
import ru.itis.kpfu304.hm1.SecondScreenFragment.Companion


class FirstScreenFragment : Fragment(R.layout.fragment_first_screen) {

    private var viewBinding : FragmentFirstScreenBinding? = null

    private lateinit var value: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }



    private fun initViews(){
        viewBinding?.run {
            mainFirstBtn.setOnClickListener {
                val inputText = mainEt.text.toString()
                val secondFragment = SecondScreenFragment.getInstance(if (inputText.isEmpty()) "Текст не был передан" else inputText)
                (requireActivity() as? MainActivity)?.replaceFragment(SecondScreenFragment.TAG, secondFragment)
            }

            mainSecondBtn.setOnClickListener {
                val inputText = mainEt.text.toString()
                val secondFragment = SecondScreenFragment.getInstance(if (inputText.isEmpty()) "Текст не был передан" else inputText)
                val thirdFragment = ThirdScreenFragment.getInstance(if (inputText.isEmpty()) "Текст не был передан" else inputText)
                (requireActivity() as? MainActivity)?.replaceFragment(SecondScreenFragment.TAG, secondFragment)
                (requireActivity() as? MainActivity)?.replaceFragment(ThirdScreenFragment.TAG, thirdFragment)
            }

            mainThirdBtn.setOnClickListener {
                val dialog = BottomSheetFragment().apply {
                    isCancelable = true
                }
                dialog.show(childFragmentManager, BottomSheetFragment.TAG)
            }

        }

    }

    fun replace(bundle: Bundle){
        viewBinding?.run{
            value = bundle.getString(ARG_KEY).toString()
            mainInputLayout.editText?.setText(value)
        }
    }



    companion object {
        const val TAG = "first_screen_fragment"
        private const val ARG_KEY = "ARG_TEXT"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}
