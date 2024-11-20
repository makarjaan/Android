package ru.itis.apphomework2.screens

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.itis.apphomework2.R
import ru.itis.apphomework2.adapter.AdapterWithMultipleHolders
import ru.itis.apphomework2.databinding.FragmentMultipleTypesBinding
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.model.ListDetailedData
import ru.itis.apphomework2.repository.ScreensContentRepository
import ru.itis.apphomework2.repository.ScreensDetailedContentRepo
import ru.itis.apphomework2.ui.decorator.SimpleDecorator
import ru.itis.apphomework2.utils.getValueInDp
import kotlin.random.Random


class MultipleTypesFragment : Fragment(R.layout.fragment_multiple_types) {

    private var viewBinding: FragmentMultipleTypesBinding? = null

    private var rvAdapter: AdapterWithMultipleHolders? = null

    private var isGridLayout = false

    private var currentDataList = mutableListOf<ListData>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMultipleTypesBinding.bind(view)
        initViews()
        if (currentDataList.isEmpty()) {
            currentDataList = ScreensContentRepository.getListContent(requireContext()).toMutableList()
        }
        initRecycleView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(ARG_GRID, isGridLayout)
    }

    private fun initViews() {
        viewBinding?.floatBtn?.setOnClickListener {
            val dialog = BottomSheetFragment().apply {
                isCancelable
            }
            dialog.show(childFragmentManager, BottomSheetFragment.TAG)
        }
    }


    private fun initRecycleView() {
        rvAdapter = AdapterWithMultipleHolders(
            requestManager = Glide.with(requireContext()),
            items = currentDataList,
            action = ::onClick,
            actionClickBtn = :: onClickBtn
        )
        viewBinding?.mainRecycle?.apply {
            adapter = rvAdapter
            getLinerLayout()
            addItemDecoration(SimpleDecorator(
                marginValue = getValueInDp(value = 16f, requireContext()).toInt()
            ))
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
    }


    fun onClickBtn(nameBtn : String) {
        isGridLayout = nameBtn == "secondBtn"
        getLinerLayout()
        viewBinding?.mainRecycle?.adapter?.notifyDataSetChanged()
    }

    fun onClick(position : Int) {

        val dataItem = currentDataList.getOrNull(position) ?: return

        val list = ScreensDetailedContentRepo().getInfo(dataItem.id)

        val fragment = DetailedInfoFragment()

        val bundle = Bundle().apply {
            putString( "string_url", list?.imageUrl)
            putString( "string_title", list?.headerText)
            putString( "string_des", list?.infoText)
        }

        fragment.arguments = bundle

        val activity = view?.context as AppCompatActivity
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun getLinerLayout() {
        viewBinding?.mainRecycle?.apply {
            if (isGridLayout) {
                layoutManager = GridLayoutManager(requireContext(), 3,RecyclerView.VERTICAL, false).apply {
                    spanSizeLookup = object :
                        GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(position: Int): Int {
                            return if (position == 0) {
                                3
                            } else {
                                1
                            }
                        }
                    }
                }
            } else {
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            }
        }
    }

    fun addRandomItems(int: Int){
        var count = int
        while (count!= 0) {
            val randomInt = Random.nextInt(1, currentDataList.size + 1)
            val randomInt2 = Random.nextInt(1, currentDataList.size + 1)
            currentDataList.add(randomInt2, ScreensContentRepository.getListContent(requireContext()).get(randomInt))
            count -= 1
        }
        rvAdapter?.addRandomElem(currentDataList)
    }

    fun deleteRandomItems(int : Int) {
        var count = int
        if (count > currentDataList.size) {
            currentDataList.subList(1, currentDataList.size).clear()
        } else {
            while (count!= 0) {
                val randomIndex = Random.nextInt(1, currentDataList.size)
                currentDataList.removeAt(randomIndex)
                count -= 1
            }
        }
        rvAdapter?.deleteRandomElem(currentDataList)
    }

    fun addRandomElem() {
        val randomInt = Random.nextInt(1, currentDataList.size + 1)
        val randomInt2 = Random.nextInt(1, currentDataList.size + 1)
        currentDataList.add(randomInt, ScreensContentRepository.getListContent(requireContext()).get(randomInt2))
        rvAdapter?.addOneRandomElem(currentDataList)
    }

    fun deleteRandomElem() {
        val randomInt = Random.nextInt(1, currentDataList.size)
        currentDataList.removeAt(randomInt)
        rvAdapter?.deleteOneRandomElem(currentDataList)
    }


    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    companion object {
        const val TAG = "multiple_screen_fragment"
        const val ARG_GRID = "is_grid_layout"
    }
}