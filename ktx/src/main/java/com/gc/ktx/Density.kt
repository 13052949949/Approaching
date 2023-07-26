package com.gc.ktx

import android.content.res.Resources
import android.util.TypedValue

fun Float.dp2px(): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

fun Int.dp2px(): Float = toFloat().dp2px()