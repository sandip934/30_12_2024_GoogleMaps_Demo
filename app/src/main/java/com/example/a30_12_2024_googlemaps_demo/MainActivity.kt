package com.example.a30_12_2024_googlemaps_demo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a30_12_2024_googlemaps_demo.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.Circle
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.Polyline

class MainActivity : AppCompatActivity(),OnMapReadyCallback {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mMap : GoogleMap
    private lateinit var marker : Marker
    private lateinit var bitcodeMarker : Marker
    private lateinit var puneMarker : Marker
    private lateinit var circle : Circle
    private lateinit var polygon: Polygon
    private lateinit var polyline: Polyline


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        initMapSetting()
        addMarker()
        addShapes()
    }

    private fun addShapes(){
        var bitcodeLating = LatLng(18.51021,73.83350)
        circle = mMap.addCircle(CircleOptions()
            .center(bitcodeLating)
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