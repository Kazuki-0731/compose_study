package com.example.mapping_sample.ui.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mapping_sample.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    var backgroundThread: HandlerThread? = null
    var backgroundHandler: Handler? = null

    private val cameraCapture:CameraCapture = CameraCapture()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonCapture.setOnClickListener {
            // カメラでキャプション
        }
        cameraCapture.initCameraCapture(binding.cameraPreview, requireActivity(), requireContext(), this)
        binding.cameraPreview.surfaceTextureListener = cameraCapture.surfaceTextureListener
        startBackgroundThread()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val image = data?.extras?.get("data")?.let {
                binding.cameraImage.apply {
                    this.setImageBitmap(it as Bitmap)
                    this.visibility = View.VISIBLE
                }
            }
        }
    }

//    override fun onRequestPermissionsResult(requestCode: Int,
//                                            permissions: Array<out String>,
//                                            grantResults: IntArray) {
//        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
//            if (grantResults.isNotEmpty() &&
//                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                takePicture()
//            }
//        }
//    }

    private fun startBackgroundThread() {
        backgroundThread = HandlerThread("CameraBackground").also { it.start() }
        backgroundHandler = Handler(backgroundThread?.looper!!)
    }

//    private fun takePicture() {
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
//            addCategory(Intent.CATEGORY_DEFAULT)
//        }
//
//        startActivityForResult(intent, CAMERA_REQUEST_CODE)
//    }
//
//    private fun checkCameraPermission() = PackageManager.PERMISSION_GRANTED ==
//            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
//
//    private fun grantCameraPermission() =
//        ActivityCompat.requestPermissions(requireActivity(),
//            arrayOf(Manifest.permission.CAMERA),
//            CAMERA_PERMISSION_REQUEST_CODE)
//
    companion object {
        const val CAMERA_REQUEST_CODE = 1
        const val CAMERA_PERMISSION_REQUEST_CODE = 2
    }
}