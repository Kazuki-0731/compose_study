package com.example.mapping_sample.ui

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CaptureRequest
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Surface
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mapping_sample.R
import com.example.mapping_sample.databinding.ActivityMainBinding
import com.example.mapping_sample.databinding.ActivityMapsBinding
import com.example.mapping_sample.ui.maps.MapsFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private var cameraDevice: CameraDevice? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ナビゲーション部
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_settings))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

//    public val stateCallback = object : CameraDevice.StateCallback() {
//        override fun onOpened(cameraDevice: CameraDevice) {
//            this@MainActivity.cameraDevice = cameraDevice
////            createCameraPreviewSession()
//        }
//        override fun onDisconnected(cameraDevice: CameraDevice) {
//            cameraDevice.close()
//            this@MainActivity.cameraDevice = null
//        }
//        override fun onError(cameraDevice: CameraDevice, error: Int) {
//            onDisconnected(cameraDevice)
//            finish()
//        }
//    }

//    private fun createCameraPreviewSession() {
//        try {
//            val texture = binding.cameraPreview.surfaceTexture
//            texture.setDefaultBufferSize(previewSize.width, previewSize.height)
//            val surface = Surface(texture)
//            previewRequestBuilder = cameraDevice!!.createCaptureRequest(
//                CameraDevice.TEMPLATE_PREVIEW
//            )
//            previewRequestBuilder.addTarget(surface)
//            cameraDevice?.createCaptureSession(Arrays.asList(surface, imageReader?.surface),
//                object : CameraCaptureSession.StateCallback() {
//
//                    override fun onConfigured(cameraCaptureSession: CameraCaptureSession) {
//
//                        if (cameraDevice == null) return
//                        captureSession = cameraCaptureSession
//                        try {
//                            previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE,
//                                CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE)
//                            previewRequest = previewRequestBuilder.build()
//                            captureSession?.setRepeatingRequest(previewRequest,
//                                null, Handler(backgroundThread?.looper!!))
//                        } catch (e: CameraAccessException) {
//                            Log.e("erfs", e.toString())
//                        }
//
//                    }
//
//                    override fun onConfigureFailed(session: CameraCaptureSession) {
//                        //Tools.makeToast(baseContext, "Failed")
//                    }
//                }, null)
//        } catch (e: CameraAccessException) {
//            Log.e("erf", e.toString())
//        }
//    }
}