package ru.itis.apphomework2.viewHolder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.apphomework2.databinding.ItemHolderSecondBinding
import ru.itis.apphomework2.model.ButtonData


class SecondTypeViewHolder (
    private val viewBinding : ItemHolderSecondBinding,
    private val action: (String) -> Unit
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindItem(itemData : ButtonData) {
        with(viewBinding) {
            firstBtn.setOnClickListener {
                action.invoke("firstBtn")
            }
            secondBtn.setOnClickListener {
                action.invoke("secondBtn")
            }

            thirdBtn.setOnClickListener {
                action.invoke("thirdBtn")
            }

        }
    }
}