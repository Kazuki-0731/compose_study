package com.example.mapping_sample.ui.dashboard

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.ImageFormat
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.hardware.camera2.params.OutputConfiguration
import android.hardware.camera2.params.SessionConfiguration
import android.media.ImageReader
import android.os.Build
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.util.Size
import android.view.Surface
import android.view.TextureView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import java.util.*

@Suppress("DEPRECATION")
class CameraCapture {
    lateinit var textureView:TextureView
    private var captureSession: CameraCaptureSession? = null
    private var cameraDevice: CameraDevice? = null
    private val previewSize: Size = Size(300, 300) // FIXME: for now.
    private lateinit var previewRequestBuilder: CaptureRequest.Builder
    private var imageReader: ImageReader? = null
    private lateinit var previewRequest: CaptureRequest
    private lateinit var activity: Activity
    private lateinit var fragment: DashboardFragment
    private lateinit var context: Context

    fun initCameraCapture(texture: TextureView, activity: Activity, context: Context, fragment: DashboardFragment){
        this.textureView = texture
        this.activity = activity
        this.fragment = fragment
        this.context = context
    }

    val surfaceTextureListener = object : TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
            imageReader = ImageReader.newInstance(width, height,
                ImageFormat.JPEG, /*maxImages*/ 2)
            openCamera()
        }
        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, p1: Int, p2: Int) {}
        override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {}
        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
            return false
        }
    }

    fun openCamera() {
        val manager: CameraManager = activity.getSystemService(Context.CAMERA_SERVICE) as CameraManager

        try {
            val cameraId: String = manager.cameraIdList[0]
            val permission = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)

            if (permission != PackageManager.PERMISSION_GRANTED) {
                requestCameraPermission()
                return
            }
            manager.openCamera(cameraId, stateCallback, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val stateCallback = object : CameraDevice.StateCallback() {
        override fun onOpened(cameraDevice: CameraDevice) {
            this@CameraCapture.cameraDevice = cameraDevice
            createCameraPreviewSession()
        }
        override fun onDisconnected(cameraDevice: CameraDevice) {
            cameraDevice.close()
            this@CameraCapture.cameraDevice = null
        }
        override fun onError(cameraDevice: CameraDevice, error: Int) {
            onDisconnected(cameraDevice)
            activity.finish()
        }
    }

    private fun requestCameraPermission() {
        if (fragment.shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            AlertDialog.Builder(context)
                .setMessage("Permission Here")
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    fragment.requestPermissions(arrayOf(Manifest.permission.CAMERA),
                        200)
                }
                .setNegativeButton(android.R.string.cancel) { _, _ ->
                    activity.finish()
                }
                .create()
        } else {
            fragment.requestPermissions(arrayOf(Manifest.permission.CAMERA), 200)
        }
    }

    private fun createCameraPreviewSession() {
        try {
            val texture = textureView.surfaceTexture
            texture!!.setDefaultBufferSize(previewSize.width, previewSize.height)
            val surface = Surface(texture)
            previewRequestBuilder = cameraDevice!!.createCaptureRequest(
                CameraDevice.TEMPLATE_PREVIEW
            )
            previewRequestBuilder.addTarget(surface)
            cameraDevice?.createCaptureSession(listOf(surface, imageReader?.surface),
                @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                object : CameraCaptureSession.StateCallback() {

                    override fun onConfigured(cameraCaptureSession: CameraCaptureSession) {

                        if (cameraDevice == null) return
                        captureSession = cameraCaptureSession
                        try {
                            previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE,
                                CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE)
                            previewRequest = previewRequestBuilder.build()
                            captureSession?.setRepeatingRequest(previewRequest,
                                null, Handler(fragment.backgroundThread?.looper!!))
                        } catch (e: CameraAccessException) {
                            Log.e("error", e.toString())
                        }
                    }

                    override fun onConfigureFailed(session: CameraCaptureSession) {
                        Toast.makeText(context, "Failed!!", Toast.LENGTH_SHORT).show()
                    }
                }, null)
        } catch (e: CameraAccessException) {
            Log.e("error", e.toString())
        }
    }
}