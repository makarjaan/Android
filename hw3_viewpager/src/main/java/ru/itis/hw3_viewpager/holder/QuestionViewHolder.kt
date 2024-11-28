package ru.itis.hw3_viewpager.holder

import android.content.res.Resources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.itis.hw3_viewpager.R
import ru.itis.hw3_viewpager.databinding.ItemRvBinding
import ru.itis.hw3_viewpager.model.ItemQuestionModel

class QuestionViewHolder(
    private val viewBinding : ItemRvBinding,
    private val onItemClick : (Int) -> Unit,
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItemData(data : ItemQuestionModel) {
        with(viewBinding) {

            textItemRv.text = data.answer
            root.setOnClickListener {
                onItemClick.invoke(adapterPosition)
            }
            val color = try {
                ContextCompat.getColor(itemView.context, data.backgroundTint)
            } catch (e: Resources.NotFoundException) {
                data.backgroundTint
            }
            root.setCardBackgroundColor(color)

            val drawable = ContextCompat.getDrawable(itemView.context, data.image)
            itemRvIv.setImageDrawable(drawable)
        }
    }

}