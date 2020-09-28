package com.deokdev.onttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class FindPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_password)

        var button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            val intent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
            if (intent.resolveActivity(packageManager) !=null) {
                startActivity(intent)
            }
        }
    }

    /** Called when the user taps the button */
    fun NextFindPassword(view: View) {
        val intent = Intent(this, InputPasswordActivity::class.java)
        startActivity(intent)
    }
}