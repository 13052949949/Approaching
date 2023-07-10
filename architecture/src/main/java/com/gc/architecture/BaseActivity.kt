package com.gc.architecture

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gc.utils.ToastUtils
import java.lang.reflect.ParameterizedType

@Suppress("UNCHECKED_CAST")
open class BaseActivity<B : ViewBinding> : AppCompatActivity(), BaseView {

    lateinit var context: Activity

    val binding: B by lazy {
        val clazz =
            (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<*>
        val method = clazz.getDeclaredMethod("inflate", LayoutInflater::class.java)
        method.isAccessible = true
        method.invoke(null, layoutInflater) as B
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)
        context = this
        initialize()
        setupViews()
        loadData()
    }

    protected open fun initialize() {

    }


    protected open fun setupViews() {

    }

    protected open fun loadData() {

    }

    override fun showLoading(msg: String?) {

    }

    override fun hideLoading() {

    }

    override fun toast(type: Int, msg: String) {
        ToastUtils.toast(context, type, msg)
    }

}