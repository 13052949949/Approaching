package com.gc.architecture

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

open class BasePresenter<V : BaseView> : IPresenter<V>, LifecycleEventObserver {

    var mView: V? = null

    override fun isAttached(): Boolean = mView != null

    override fun attachView(view: V) {
        mView = view
        mView?.lifecycle?.addObserver(this)
    }

    override fun detachView() {
        mView?.lifecycle?.removeObserver(this)
        mView = null
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.e(source.javaClass.simpleName, event.toString())
        if (event == Lifecycle.Event.ON_DESTROY){
            detachView()
        }
    }


}