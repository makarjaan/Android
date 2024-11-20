package ru.itis.apphomework2.ui.decorator

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.itis.apphomework2.R
import ru.itis.apphomework2.viewHolder.FirstTypeViewHolder
import ru.itis.apphomework2.viewHolder.SecondTypeViewHolder

class SimpleDecorator(
    private val marginValue: Int
) : RecyclerView.ItemDecoration(){

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val holder = parent.getChildViewHolder(view)
        if (holder is FirstTypeViewHolder) {
            outRect.apply {
                left = marginValue
                right = marginValue
            }
        } else {
            outRect.setEmpty()
        }
    }

}