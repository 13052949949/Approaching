package com.gc.architecture.demo

import com.gc.architecture.BasePresenter
import com.gc.architecture.BaseView
import com.gc.utils.ERROR

class DemoPresenter : BasePresenter<BaseView>(), DemoContract.Presenter {

    private val model = DemoModel()

    override fun requestContentTextString(callBack: (String) -> Unit) {
        model.requestContentTextStringFromServer { response->
            if (response.isNullOrEmpty()){
                mView?.toast(ERROR,"请求失败")
                return@requestContentTextStringFromServer
            }
            callBack(response)
        }
    }

}