package com.example.a30_12_2024_googlemaps_demo

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.Polyline

class MapsFragment : Fragment() {

    private lateinit var mMap : GoogleMap
    private lateinit var marker : Marker
    private lateinit var bitcodeMarker : Marker
    private lateinit var puneMarker : Marker
    private lateinit var circle : Circle
    private lateinit var polygon: Polygon
    private lateinit var polyline: Polyline


    private val callback = OnMapReadyCallback { googleMap -> mMap = googleMap

//        /**
//         * Manipulates the map once available.
//         * This callback is triggered when the map is ready to be used.
//         * This is where we can add markers or lines, add listeners or move the camera.
//         * In this case, we just add a marker near Sydney, Australia.
//         * If Google Play services is not installed on the device, the user will be prompted to
//         * install it inside the SupportMapFragment. This method will only be triggered once the
//         * user has installed Google Play services and returned to the app.
//         */
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        addShapes()
        addMarker()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        if (mapFragment != null) {
            mapFragment?.getMapAsync(callback)

        }
    }

    private fun addShapes(){
        var bitcodeLatLng = LatLng(18.51021,73.83350)
        circle = mMap.addCircle(
            CircleOptions()
            .center(bitcodeLatLng)
            .radius(500.0)
            .strokeColor(Color.CYAN)
            .strokeWidth(10.0F)
            .fillColor(Color.YELLOW)
            .zIndex(40.0F))
    }
    private fun addMarker(){
        var bitcodeLatLng = LatLng(18.51021,73.83350)
        var markerOptions = MarkerOptions()
        bitcodeMarker = mMap.addMarker(markerOptions
            .position(bitcodeLatLng)
            .rotation(45.0F)
            .title("Bitcode")
        )!!

        var puneLatLng = LatLng(18.52975,73.85196)
        puneMarker = mMap.addMarker(MarkerOptions()
            .position(puneLatLng)
            .rotation(20.0F)
            .title("Pune Marker"))!!
    }

    @SuppressLint("MissingPermission")
    private fun initMapSetting(){
        mMap.isIndoorEnabled = true
        mMap.isTrafficEnabled = true
        mMap.isBuildingsEnabled = true
        mMap.isMyLocationEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isTiltGesturesEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isScrollGesturesEnabled = true
        mMap.uiSettings.isRotateGesturesEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true
    }

}