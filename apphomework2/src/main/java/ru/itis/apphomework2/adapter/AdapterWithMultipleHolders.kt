package ru.itis.apphomework2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import ru.itis.apphomework2.R
import ru.itis.apphomework2.databinding.ItemHolderFirstBinding
import ru.itis.apphomework2.databinding.ItemHolderGridsecondElemOneBinding
import ru.itis.apphomework2.databinding.ItemHolderGridsecondElemSecondBinding
import ru.itis.apphomework2.databinding.ItemHolderSecondBinding
import ru.itis.apphomework2.databinding.ItenHolderGridElemOneBinding
import ru.itis.apphomework2.model.ButtonData
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.model.ListDetailedData
import ru.itis.apphomework2.model.ListRecycleMainData
import ru.itis.apphomework2.screens.MultipleTypesFragment
import ru.itis.apphomework2.utils.DisplayType
import ru.itis.apphomework2.viewHolder.FirstTypeViewHolder
import ru.itis.apphomework2.viewHolder.FiveTypeViewHolder
import ru.itis.apphomework2.viewHolder.FourTypeViewHolder
import ru.itis.apphomework2.viewHolder.SecondTypeViewHolder
import ru.itis.apphomework2.viewHolder.ThirdTypeViewHolder
import kotlin.random.Random

class AdapterWithMultipleHolders(
    private val requestManager: RequestManager,
    private val action: (Int) -> Unit,
    private var actionClickBtn: (String) -> Unit,
    private val onLongClick: (Int) -> Unit,
    items : List<ListData>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList = mutableListOf<ListData>()
    private var currentDisplayType: DisplayType = DisplayType.LIST

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("TEST-TAG", "${viewType}")
        return when (viewType) {
            R.layout.item_holder_first -> {
                FirstTypeViewHolder (
                    viewBinding = ItemHolderFirstBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    requestManager = requestManager,
                    action = action
                )
            }

            R.layout.item_holder_second -> {
                SecondTypeViewHolder (
                    viewBinding = ItemHolderSecondBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    action = actionClickBtn,
                )
            }

            R.layout.iten_holder_grid_elem_one -> {
                ThirdTypeViewHolder (
                    viewBinding = ItenHolderGridElemOneBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    requestManager = requestManager,
                    action = action,
                    onLongClick = onLongClick
                )
            }
            R.layout.item_holder_gridsecond_elem_one -> {
                val binding = ItemHolderGridsecondElemOneBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false)

                binding.root.post {
                    binding.root.layoutParams.height = parent.width/2
                    binding.root.requestLayout()
                }

                FourTypeViewHolder (
                    viewBinding = binding,
                    requestManager = requestManager,
                    action = action
                )
            }
            R.layout.item_holder_gridsecond_elem_second -> {

                val binding = ItemHolderGridsecondElemSecondBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                binding.root.post {
                    val newHeight = parent.width - 80
                    binding.root.apply {
                        layoutParams.height = newHeight
                        layoutParams.width = newHeight/2
                        requestLayout()
                    }
                }

                FiveTypeViewHolder (
                    viewBinding = binding,
                    requestManager = requestManager,
                    action = action
                )
            }

            else -> throw IllegalStateException("Uncorrect holder")
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is FirstTypeViewHolder -> {
                (holder as? FirstTypeViewHolder)?.bindItem(itemData = dataList[position] as ListRecycleMainData)
            }

            is SecondTypeViewHolder -> {
                (holder as? SecondTypeViewHolder)?.bindItem(itemData = dataList[position] as ButtonData)
            }

            is ThirdTypeViewHolder -> {
                (holder as? ThirdTypeViewHolder)?.bindItem(itemData = dataList[position] as ListRecycleMainData)
            }

            is FourTypeViewHolder -> {
                (holder as? FourTypeViewHolder)?.bindItem(itemData = dataList[position] as ListRecycleMainData)
            }

            is FiveTypeViewHolder -> {
                (holder as? FiveTypeViewHolder)?.bindItem(itemData = dataList[position] as ListRecycleMainData)
            }

            else -> Unit
        }
    }

    override fun getItemViewType(position: Int): Int {
        //Log.d("TEST-TAG", "${currentDisplayType}")

        if (dataList[position] is ButtonData) return R.layout.item_holder_second

        return when(currentDisplayType) {
            DisplayType.LIST -> R.layout.item_holder_first
            DisplayType.GRID -> R.layout.iten_holder_grid_elem_one
            DisplayType.VERTICAL_GRID -> {
                val indexPosition = (position - 1) % 4
                if (indexPosition == 0 || indexPosition == 3) {
                    R.layout.item_holder_gridsecond_elem_one
                } else {
                    R.layout.item_holder_gridsecond_elem_second
                }
            }
        }
    }

    fun updateList(newList : MutableList<ListData>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

    fun updateDisplayType(newDisplayType: DisplayType) {
        currentDisplayType = newDisplayType
        notifyDataSetChanged()
    }
}
