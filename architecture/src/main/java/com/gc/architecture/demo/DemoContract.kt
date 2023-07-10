package com.gc.architecture.demo

import com.gc.architecture.BaseView

interface DemoContract {

    interface Model {
        fun requestContentTextStringFromServer(callBack: (String?) -> Unit)
    }

    interface Presenter {
        fun requestContentTextString(callBack: (String) -> Unit)
    }

    interface View : BaseView {

    }

}