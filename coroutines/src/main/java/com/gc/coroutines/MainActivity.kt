package com.gc.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.concurrent.thread

const val TAG = "ggyy"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        GlobalScope.launch {
//            Log.e(TAG, "Coroutines Camp 1 ${Thread.currentThread().name}")
//        }
//
//        Thread{
//            Log.e(TAG, "Coroutines Camp 2 ${Thread.currentThread().name}")
//        }.start()
//
//        thread {
//            Log.e(TAG, "Coroutines Camp 3 ${Thread.currentThread().name}")
//        }
//
//        thread {
//            ioCode1()
//            runOnUiThread {
//                uiCode1()
//                thread {
//                    ioCode2()
//                    runOnUiThread {
//                        uiCode2()
//                        thread {
//                            ioCode3()
//                            runOnUiThread {
//                                uiCode3()
//                            }
//                        }
//                    }
//                }
//            }
//        }

        //线程环境
        GlobalScope.launch (Dispatchers.Main){
            ioCode1()
            uiCode1()
            ioCode2()
            uiCode2()
            ioCode3()
            uiCode3()
        }

    }

    suspend fun ioCode1(){
        withContext(Dispatchers.IO){
            delay(2000)
            Log.e(TAG, "Coroutines Camp io1 ${Thread.currentThread().name}")
        }
    }

    fun uiCode1(){
        Log.e(TAG, "Coroutines Camp ui1 ${Thread.currentThread().name}")
    }

    suspend fun ioCode2(){
        withContext(Dispatchers.IO){
            delay(2000)
            Log.e(TAG, "Coroutines Camp io2 ${Thread.currentThread().name}")
        }
    }

    fun uiCode2(){
        Log.e(TAG, "Coroutines Camp ui2 ${Thread.currentThread().name}")
    }

   suspend fun ioCode3(){
       withContext(Dispatchers.IO){
           delay(2000)
           Log.e(TAG, "Coroutines Camp io3 ${Thread.currentThread().name}")
       }
    }

    fun uiCode3(){
        Log.e(TAG, "Coroutines Camp ui3 ${Thread.currentThread().name}")
    }

}