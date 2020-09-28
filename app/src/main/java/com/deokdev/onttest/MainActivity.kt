package com.deokdev.onttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the 복구하기(Start Restore) button */
    fun startRestore(view: View) {
        val intent = Intent(this, CheckDeviceActivity::class.java)
        startActivity(intent)
    }
}