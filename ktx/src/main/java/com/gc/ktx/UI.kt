package com.gc.ktx

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.gone() {
    visibility = GONE
}

fun View.gone(gone: Boolean) {
    visibility = if (gone) GONE else VISIBLE
}

fun View.visible() {
    visibility = VISIBLE
}

fun View.visible(visible: Boolean) {
    visibility = if (visible) VISIBLE else GONE
}

