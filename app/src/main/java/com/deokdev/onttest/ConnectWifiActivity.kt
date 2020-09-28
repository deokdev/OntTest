package com.deokdev.onttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button

class ConnectWifiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect_wifi)

        var button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            val intent = Intent(android.provider.Settings.ACTION_WIFI_SETTINGS)
            if (intent.resolveActivity(packageManager) !=null) {
                startActivity(intent)
            }
        }
    }

    /** Called when the user taps the button */
    fun NextConnectWifi(view: View) {
        val intent = Intent(this, FindPasswordActivity::class.java)
        startActivity(intent)
    }
}