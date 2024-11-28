package ru.itis.hw3_viewpager.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.hw3_viewpager.databinding.ItemRvBinding
import ru.itis.hw3_viewpager.holder.QuestionViewHolder
import ru.itis.hw3_viewpager.model.ItemQuestionModel

class QuestionAdapter(
    private val action : (Int) -> Unit,
    items: List<ItemQuestionModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList = mutableListOf<ItemQuestionModel>()
    private var selectedPosition: Int = RecyclerView.NO_POSITION

    init {
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return QuestionViewHolder(
            viewBinding = ItemRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick = action
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? QuestionViewHolder)?.bindItemData(data = dataList[position])
    }

    override fun getItemCount(): Int = dataList.size


    fun updateSelection(colorNotAnswer: Int, colorIsAnswer: Int, imageNotAnswer: Int, imageAnswer: Int, position: Int) {
        if (selectedPosition != position) {
            if (selectedPosition != RecyclerView.NO_POSITION) {
                dataList[selectedPosition].isAnswerd = false
                updateItem(
                    colorNotAnswer,
                    colorIsAnswer,
                    imageNotAnswer,
                    imageAnswer,
                    selectedPosition
                )
            }
            dataList[position].isAnswerd = true
            updateItem(colorNotAnswer, colorIsAnswer, imageNotAnswer, imageAnswer, position)
            selectedPosition = position
        }
    }

    fun updateItem(colorNotAnswer: Int, colorIsAnswer: Int, imageNotAnswer: Int, imageAnswer: Int, position: Int) {
        if (dataList[position].isAnswerd) {
            dataList[position].backgroundTint = colorIsAnswer
            dataList[position].image = imageAnswer
        } else {
            dataList[position].backgroundTint = colorNotAnswer
            dataList[position].image = imageNotAnswer
        }
        notifyItemChanged(position)
    }



}