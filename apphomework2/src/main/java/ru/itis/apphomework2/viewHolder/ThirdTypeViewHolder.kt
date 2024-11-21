package ru.itis.apphomework2.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.apphomework2.databinding.ItenHolderGridElemOneBinding
import ru.itis.apphomework2.model.ListRecycleMainData

class ThirdTypeViewHolder (
    private val viewBinding : ItenHolderGridElemOneBinding,
    private val requestManager : RequestManager,
    private val action : (Int) -> Unit,
    private val onLongClick: (Int) -> Unit
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(itemData : ListRecycleMainData) {
        with(viewBinding) {
            requestManager.load(itemData.imageUrl)
                .into(elemIm)

            elemTv.text = itemData.description

            root.setOnClickListener {
                action.invoke(adapterPosition)
            }

            root.setOnLongClickListener {
                onLongClick.invoke(adapterPosition)
                true
            }
        }
    }
}