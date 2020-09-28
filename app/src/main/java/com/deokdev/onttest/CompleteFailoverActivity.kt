package com.deokdev.onttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CompleteFailoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_failover)
    }

    /** Called when the user taps the button */
    fun NextCompleteFailover(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}