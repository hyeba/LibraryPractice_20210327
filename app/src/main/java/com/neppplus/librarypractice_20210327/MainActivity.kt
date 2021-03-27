package com.neppplus.librarypractice_20210327

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profilePictureImg.setOnClickListener {

//            사진 크게 보는 화면으로 이동

            val myIntent = Intent(this, ViewProfilePictureActivity::class.java)
            startActivity(myIntent)


        }

    }
}