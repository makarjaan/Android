package ru.itis.apphomework2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import ru.itis.apphomework2.R
import ru.itis.apphomework2.databinding.ItemHolderFirstBinding
import ru.itis.apphomework2.databinding.ItemHolderSecondBinding
import ru.itis.apphomework2.model.ButtonData
import ru.itis.apphomework2.model.ListData
import ru.itis.apphomework2.model.ListDetailedData
import ru.itis.apphomework2.model.ListRecycleMainData
import ru.itis.apphomework2.viewHolder.FirstTypeViewHolder
import ru.itis.apphomework2.viewHolder.SecondTypeViewHolder
import kotlin.random.Random

class AdapterWithMultipleHolders(
    private val requestManager: RequestManager,
    private val action: (Int) -> Unit,
    private val actionClickBtn: (String) -> Unit,
    items : List<ListData>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var dataList = mutableListOf<ListData>()

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
                    action = actionClickBtn
                )
            }

            else -> throw IllegalStateException("Uncorrect holder")
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (dataList[position]) {
            is ListRecycleMainData -> {
                (holder as? FirstTypeViewHolder)?.bindItem(itemData = dataList[position] as ListRecycleMainData)
            }

            is ButtonData -> {
                (holder as? SecondTypeViewHolder)?.bindItem(itemData = dataList[position] as ButtonData)
            }

            else -> Unit
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is ListRecycleMainData -> {
                R.layout.item_holder_first
            }

            is ButtonData -> {
                R.layout.item_holder_second
            }

            else -> throw IllegalStateException("Incorrect holder type")
        }
    }

    fun addRandomElem(newList : MutableList<ListData>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

    fun deleteRandomElem(newList : List<ListData>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

    fun addOneRandomElem(newList : List<ListData>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

    fun deleteOneRandomElem(newList : List<ListData>) {
        dataList.clear()
        dataList.addAll(newList)
        notifyDataSetChanged()
    }

}
