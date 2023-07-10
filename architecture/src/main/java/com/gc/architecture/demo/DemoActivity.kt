package com.gc.architecture.demo

import android.annotation.SuppressLint
import com.gc.architecture.BaseActivity
import com.gc.architecture.databinding.ActivityMainBinding
import com.gc.utils.SUCCEED

class DemoActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var presenter: DemoPresenter

    override fun initialize() {
        super.initialize()
        presenter = DemoPresenter()
        presenter.attachView(this)
    }

    @SuppressLint("SetTextI18n")
    override fun setupViews() {
        super.setupViews()
        binding.tvContent.text = "Hello Kotlin"
    }

    override fun loadData() {
        super.loadData()
        presenter.requestContentTextString { content->
            binding.tvContent.text = content
            toast(SUCCEED,"请求成功")
        }
    }

}