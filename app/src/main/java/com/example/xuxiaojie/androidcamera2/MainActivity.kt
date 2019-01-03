package com.example.xuxiaojie.androidcamera2

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import com.example.xuxiaojie.androidcamera2.R.id.btn_open_camera
import com.example.xxj.camera.CameraActivity
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

class MainActivity : AppCompatActivity() {
    companion object {
        private const val PERMISSION_CAMERA = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_open_camera.setOnClickListener {
            startCameraActivity()
        }
    }

    @AfterPermissionGranted(PERMISSION_CAMERA)
    private fun startCameraActivity() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            startActivity(Intent(this, CameraActivity::class.java))
        } else {
            EasyPermissions.requestPermissions(this, "camera permission", PERMISSION_CAMERA, Manifest.permission.CAMERA)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}
