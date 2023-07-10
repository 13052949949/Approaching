package com.gc.architecture.demo

class DemoModel:DemoContract.Model {

    override fun requestContentTextStringFromServer(callBack: (String?) -> Unit) {
        callBack("This is response content string.")
    }

}