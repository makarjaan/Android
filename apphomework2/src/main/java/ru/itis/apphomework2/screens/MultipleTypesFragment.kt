package ru.itis.apphomework2.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import ru.itis.apphomework2.R
import ru.itis.apphomework2.adapter.AdapterWithMultipleHolders
import ru.itis.apphomework2.databinding.FragmentMultipleTypesBinding
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.repository.ScreensContentRepository
import ru.itis.apphomework2.repository.ScreensDetailedContentRepo
import ru.itis.apphomework2.ui.decorator.SimpleDecorator
import ru.itis.apphomework2.utils.DisplayType
import ru.itis.apphomework2.utils.getValueInDp
import kotlin.random.Random


class MultipleTypesFragment : Fragment(R.layout.fragment_multiple_types) {

    private var viewBinding: FragmentMultipleTypesBinding? = null

    private var rvAdapter: AdapterWithMultipleHolders? = null

    private var isGridLayout = false

    private var isThirdGridLayout = false

    private var currentDisplayType = DisplayType.LIST

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
            addItemDecoration(SimpleDecorator(marginValue =
                getValueInDp(value = 8f, requireContext()).toInt()))
        }
    }


    fun onClickBtn(nameBtn : String) {
        isGridLayout = nameBtn == "secondBtn"
        isThirdGridLayout = nameBtn == "thirdBtn"
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
                currentDisplayType = DisplayType.GRID
                layoutManager = GridLayoutManager(context, 3, RecyclerView.VERTICAL, false).apply {
                    spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(position: Int): Int {
                            return if (position == 0) 3
                            else 1
                        }
                    }
                }
            }
            if (isThirdGridLayout){
                currentDisplayType = DisplayType.VERTICAL_GRID
                layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false).apply {
                    spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(position: Int): Int {
                            return if (position == 0 || (position - 1) % 4 in listOf(0, 3)) 2 else 1
                        }
                    }
                }
            }
            if (!isGridLayout and !isThirdGridLayout) {
                currentDisplayType = DisplayType.LIST
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            }
        }
        rvAdapter?.updateDisplayType(currentDisplayType)
    }

    fun addRandomItems(int: Int){
        var count = int
        while (count!= 0) {
            val randomInt = Random.nextInt(1, ScreensContentRepository.getListContent(requireContext()).size)
            val randomInt2 = Random.nextInt(1, currentDataList.size + 1)
            currentDataList.add(randomInt2, ScreensContentRepository.getListContent(requireContext()).get(randomInt))
            count -= 1
        }
        rvAdapter?.updateList(currentDataList)
    }

    fun deleteRandomItems(int : Int) {
        var count = int
        if (count > currentDataList.size) {
            currentDataList.subList(1, currentDataList.size).clear()
        } else {
            while (count!= 0) {
                val randomIndex = Random.nextInt(1, currentDataList.size + 1)
                currentDataList.removeAt(randomIndex)
                count -= 1
            }
        }
        rvAdapter?.updateList(currentDataList)
    }

    fun addRandomElem() {
        val randomInt = Random.nextInt(1, ScreensContentRepository.getListContent(requireContext()).size)
        val randomInt2 = Random.nextInt(1, currentDataList.size + 1)
        currentDataList.add(randomInt2, ScreensContentRepository.getListContent(requireContext()).get(randomInt))
        rvAdapter?.updateList(currentDataList)
    }

    fun deleteRandomElem() {
        val randomInt = Random.nextInt(1, currentDataList.size + 1)
        currentDataList.removeAt(randomInt)
        rvAdapter?.updateList(currentDataList)
    }


    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    companion object {
        const val TAG = "multiple_screen_fragment"
    }
}