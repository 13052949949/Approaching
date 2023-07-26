package com.gc.customviewdrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ReviewDashBoardView>(R.id.dashBoardView).setOnClickListener {
            (it as ReviewDashBoardView).mark ++
        }
    }
}