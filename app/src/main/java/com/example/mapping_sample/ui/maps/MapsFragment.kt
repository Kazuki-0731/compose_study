package com.example.mapping_sample.ui.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mapping_sample.R
import com.example.mapping_sample.databinding.FragmentDashboardBinding
import com.example.mapping_sample.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(R.layout.fragment_maps), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var mapsViewModel: MapsViewModel
    private var _binding: FragmentMapsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        mapsViewModel =
//            ViewModelProvider(this).get(MapsViewModel::class.java)
//        _binding = FragmentMapsBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//        val textView: TextView = binding.textDashboard
//        mapsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//        return binding.root
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}

//class MapsFragment : SupportMapFragment(){
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_maps, container, false)
//    }
//}