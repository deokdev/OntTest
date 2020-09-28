package com.deokdev.onttest

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

//class VolleyService : Service() {
object VolleyService {

//    override fun onBind(intent: Intent): IBinder {
//        TODO("Return the communication channel to the service.")
//    }

//    var testUrl = "http://192.168.0.5:5000/?id=hotspot&key=34567890"
    var testUrl = "http://192.168.100.1:5000/?id=deok&key=34567890"

    fun testVolley(context: Context, success: (Boolean) -> Unit) {
        val myJson = JSONObject()
        val requestBody = myJson.toString()

        val testRequest = object : StringRequest(Method.GET, testUrl, Response.Listener { response ->
            println("서버 Response 수신: $response")
            success(true)
        }, Response.ErrorListener { error ->
            Log.d("ERROR", "서버 Response 가져오기 실패: $error")
            success(false)
        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
//                return super.getBodyContentType()
            }

            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }
        }

        Volley.newRequestQueue(context).add(testRequest)
    }
}