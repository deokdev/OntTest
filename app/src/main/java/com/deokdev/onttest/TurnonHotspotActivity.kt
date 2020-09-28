package com.deokdev.onttest

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.net.HttpURLConnection
import java.net.URL

class TurnonHotspotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turnon_hotspot)

        var button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            val intent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
            if (intent.resolveActivity(packageManager) !=null) {
                startActivity(intent)
            }
        }

        val textView13 = findViewById<TextView>(R.id.textView13)



    }

    /** Called when the user taps the button */
    fun NextTurnonHotspot(view: View) {
        val intent = Intent(this, CompleteFailoverActivity::class.java)
        startActivity(intent)
    }
}