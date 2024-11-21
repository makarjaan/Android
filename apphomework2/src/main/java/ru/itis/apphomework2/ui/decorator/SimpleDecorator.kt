package ru.itis.apphomework2.ui.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class SimpleDecorator(
    private val marginValue: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = marginValue
        outRect.right = marginValue
        outRect.top = marginValue
        outRect.bottom = marginValue
    }

}