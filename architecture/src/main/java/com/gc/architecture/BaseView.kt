package com.gc.architecture

import androidx.lifecycle.LifecycleOwner

interface BaseView : LifecycleOwner {

    fun showLoading(msg: String?)

    fun hideLoading()

    fun toast(type: Int, msg: String)

}