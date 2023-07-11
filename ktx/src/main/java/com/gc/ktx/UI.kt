package com.gc.ktx

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator

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

fun View.jitter() {
    val animation = AnimationUtils.loadAnimation(context, R.anim.shake)
    startAnimation(animation)
}

fun View.flicker() {
    val animation = AlphaAnimation(1f, 0f)
    animation.duration = 500
    animation.interpolator = LinearInterpolator()
    animation.repeatCount = Animation.INFINITE
    animation.repeatMode = Animation.REVERSE
    startAnimation(animation)
}

fun View.stopFlicker() = clearAnimation()