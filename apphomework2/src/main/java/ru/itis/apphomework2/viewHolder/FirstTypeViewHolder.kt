package ru.itis.apphomework2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.apphomework2.databinding.ItemHolderFirstBinding
import ru.itis.apphomework2.model.ListDetailedData
import ru.itis.apphomework2.model.ListRecycleMainData

class FirstTypeViewHolder (
    private val viewBinding : ItemHolderFirstBinding,
    private val requestManager : RequestManager,
    private val action : (Int) -> Unit
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(itemData : ListRecycleMainData) {
        with(viewBinding) {
            requestManager.load(itemData.imageUrl)
                .into(pictureIv)

            infoTv.text = itemData.description

            root.setOnClickListener {
                action.invoke(adapterPosition)
            }
        }
    }
}