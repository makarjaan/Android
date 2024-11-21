package ru.itis.apphomework2.utils

import android.content.Context
import android.util.TypedValue

fun getValueInDp(value: Float, ctx: Context): Float {
    val metric = ctx.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metric)
}