package com.neppplus.librarypractice_20210327

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        활동 내역 이미지를 -> 인터넷에 있는 이미지를 Glide를 통해서 불러내자
        Glide.with(this).load("http://ppss.kr/wp-content/uploads/2019/11/02-78-540x299.jpg").into(actionImg)


        callBtn.setOnClickListener {

//            버튼이 눌리면 => 권한이 있는지 확인 => OK 일 때,  바로 전화 연결
//            권한이 없으면 => 연결불가 안내 토스트

//            권한 상태에 따른 행동 방침(가이드북)을 변수로 저장

            val permissionListener = object : PermissionListener  {
                override fun onPermissionGranted() {
                    
//                    권한이 허용되어 있는 경우 => 여기 { } 내용 실행
//                    실제로 전화를 걸자

                    val myUri = Uri.parse("tel:010-5511-7777")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                    
                    
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    
//                    권한이 최종 거절 되었을 때 => 토스트로 안내 문구

                    Toast.makeText(this@MainActivity, "권한이 거부되어 전화 연결이 불가합니다", Toast.LENGTH_SHORT).show()
                    
                }

            }


//            그 방침을 가지고 실제로 권한 확인

            TedPermission.with(this)
                    .setPermissionListener(permissionListener)
                    .setDeniedMessage("[설정] > [권한]에서 권한을 허용해주세요")
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check()

        }

        profilePictureImg.setOnClickListener {

//            사진 크게 보는 화면으로 이동

            val myIntent = Intent(this, ViewProfilePictureActivity::class.java)
            startActivity(myIntent)


        }

    }
}