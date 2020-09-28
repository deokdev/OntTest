package com.deokdev.onttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CheckDeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_device)
    }

    /** Called when the user taps the button */
    fun NextCheckDevice(view: View) {
        val intent = Intent(this, ConnectWifiActivity::class.java)
        startActivity(intent)
    }
}