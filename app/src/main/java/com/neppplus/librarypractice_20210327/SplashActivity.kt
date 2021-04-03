package com.neppplus.librarypractice_20210327

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        2.5초 후 메인화면으로 이동
       val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed({

            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)

            finish()

        }, 2500)

    }
}