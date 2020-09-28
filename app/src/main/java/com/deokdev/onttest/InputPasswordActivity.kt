package com.deokdev.onttest

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WifiConfiguration
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.lang.reflect.Method
import java.net.HttpURLConnection
import java.net.URL

class InputPasswordActivity : AppCompatActivity() {



//    lateinit var wifiManager: WifiManager

//    lateinit var wifiScanReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_password)

        Log.e("deok", "#### top of onCreate")

/*
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val methods: Array<Method> = wifiManager.javaClass.declaredMethods
//        val methods: Array<Method> = wifiManager::class.kotlin
        Log.e("deok", "#### top of for")
        for (m in methods) {
            Log.e("deok", "#### methods="+m.toString())
            if (m.getName().equals("getWifiApConfiguration")) {
                Log.e("deok", "#### 01")
//                val config = m.invoke(wifiManager) as WifiConfiguration
                val config = m(wifiManager) as WifiConfiguration
                Log.e("deok", "#### 02")
                val ssid = config.SSID
                Log.e("deok", "#### 03")
//                val bssid = config.BSSID
                //or other info about the current hotspot, accessible through config
                Log.e("deok", "ssid"+ssid)
                Toast.makeText(this, "ssid"+ssid, Toast.LENGTH_SHORT).show()
            }
        }
*/

        fun sendGetRequest(ssid: String, password: String) {
            val url = URL("http://www.google.com")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET" // optional default is GET
                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                inputStream.bufferedReader().use {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        it.lines().forEach { line ->
                            println(line)
                        }
                    }
                }
            }
        }

        fun sendGetSimple() {
            val res = URL("http://192.168.100.1:5000/?id=Deok_1a_00_38&key=1234qwer").readText()
        }

//        var button10 = findViewById<Button>(R.id.button10)
//        button10.setOnClickListener {
//            sendGetSimple()
//            Toast.makeText(this, "전송을 시작합니다", Toast.LENGTH_SHORT).show()
//        }

        var button10 = findViewById<Button>(R.id.button10)
        button10.setOnClickListener {
            VolleyService.testVolley(this) { testSuccess ->
                if (testSuccess) {
                    Toast.makeText(this, "통신 성공!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "통신 실패...!", Toast.LENGTH_LONG).show()
                }
            }
        }

//        getCurrentNetworkDetail()

    }


/*
    fun enableWifi(view: View) {
        wifiManager.isWifiEnabled = true
        Toast.makeText(this, "Wifi enabled", Toast.LENGTH_SHORT).show()
    }

    fun disableWifi(view: View) {
        wifiManager.isWifiEnabled = false
        Toast.makeText(this, "wifi disbled", Toast.LENGTH_SHORT).show()
    }
*/


/*
    fun getConfigured(view: View) {
        val string = if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.e("deok", "no permissions")
            Toast.makeText(this, "There are missing permissions", Toast.LENGTH_SHORT).show()
            return
        } else {
            Log.e("deok", "fail fail")
            Toast.makeText(this, "fail fail", Toast.LENGTH_SHORT).show()
        }
        val str = wifiManager.configuredNetworks.toString()
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
*/


/*
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getCurrentNetworkDetail(view: View) {
        val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connManager.getNetworkInfo(TYPE_WIFI)
//        val networkCapabilities = connManager.getNetworkCapabilities()
        if (networkInfo.isConnected) {
            val wifiManager =
                getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
            val connectionInfo = wifiManager.connectionInfo
            if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.ssid)) {
                Log.e("ssid", connectionInfo.ssid)
                Toast.makeText(this, "ssid:"+connectionInfo.ssid, Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, "bssid:"+connectionInfo.bssid, Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, "networkId:"+connectionInfo.networkId, Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, "ssid: success", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Log.e("ssid", "No Connection")
            Toast.makeText(this, "ssid: No Connection", Toast.LENGTH_SHORT).show()
        }
    }
*/

/*
    private fun getCurrentNetworkDetail() {
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val wifiInfo = wifiManager.getNetworkInfo(WifiManager.)

    }
*/

    /** Called when the user taps the button */
    fun NextInputPassword(view: View) {
        VolleyService.testVolley(this) { testSuccess ->
            if (testSuccess) {
                Toast.makeText(this, "전송에 성공했습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "전송에 실패했습니다", Toast.LENGTH_SHORT).show()
            }
        }

        val intent = Intent(this, TurnonHotspotActivity::class.java)
        startActivity(intent)
    }

    /** Called when the user taps the button, dialog */
    fun ConfirmSending(view: View) {
        var dlg = AlertDialog.Builder(this)
        dlg.setTitle("전송하시겠습니까?")
        dlg.setMessage("ONT로 핫스팟 이름과 비밀번호를 전송합니다")
        dlg.setPositiveButton("확인") { dialog, which ->
//            Toast.makeText(this, "전송을 시작합니다", Toast.LENGTH_SHORT).show()
            NextInputPassword(view)
        }
        dlg.setNegativeButton("취소", null)
        dlg.show()
    }
}