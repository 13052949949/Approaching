package com.gc.architecture

interface IPresenter<V : BaseView> {

    fun attachView(view: V)

    fun detachView()

    fun isAttached(): Boolean
}