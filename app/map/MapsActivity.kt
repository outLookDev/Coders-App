package com.hudazamov.myquran.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.*
import android.content.IntentSender
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.common.api.ResolvableApiException
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.hudazamov.myquran.R
import com.mancj.materialsearchbar.MaterialSearchBar
import com.skyfishjy.library.RippleBackground
import java.io.IOException


open class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var map: GoogleMap? = null
    private var locationCallback: LocationCallback? = null
    private var mLocation: Location? = null
    private var mapView: View? = null

    private val mRequestCode = 100
    private val type = "mosque"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        if (!checkPermissionsFromDevice()) {
            requestPermissions()
        }else {

            val mapFragment =
                supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            mapView = mapFragment.view
            mapFragment.getMapAsync(this)
        }
        Places.initialize(this, R.string.google_maps_key.toString())
        Places.createClient(this)

        initSearchBar()
    }

    private fun checkPermissionsFromDevice(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==
                PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            1000
        )
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(mMap: GoogleMap) {
        map = mMap
        mMap.isMyLocationEnabled = true
        moveLocationButtonToBottom(mMap)
        checkGPSOpened()
    }

    private fun moveLocationButtonToBottom(mMap: GoogleMap) {
        if ((mapView != null && mapView!!.findViewById<View>(Integer.parseInt("1")) != null)) {
            val locationButton =
                (mapView!!.findViewById<View>(Integer.parseInt("1")).parent as View).findViewById<View>(
                    Integer.parseInt("2")
                )
            val layoutParams = locationButton.layoutParams as RelativeLayout.LayoutParams
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            layoutParams.setMargins(0, 0, 40, 50)
        }

        mMap.setOnMyLocationButtonClickListener {
            val searchBar: MaterialSearchBar = findViewById(R.id.searchBar1)

            if (searchBar.isSearchEnabled) {
                searchBar.disableSearch()
            }
            false
        }
    }

    private fun checkGPSOpened() {
        //check if gps is enabled or not and then request user to enable it
        val locationRequest: LocationRequest = LocationRequest.create()
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
        val settingsClient= LocationServices.getSettingsClient(this)
        val task = settingsClient.checkLocationSettings(builder.build())

        task.addOnSuccessListener(this) { getDeviceLocation() }
        task.addOnFailureListener(this) {
            if (it is ResolvableApiException) {
                try {
                    it.startResolutionForResult(this, mRequestCode)
                } catch (e1: IntentSender.SendIntentException) {
                    e1.printStackTrace()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getDeviceLocation() {
        val mFusedLocationProviderClient = FusedLocationProviderClient(this)
        val addOnCompleteListener = mFusedLocationProviderClient.lastLocation
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    mLocation = it.result
                    if (mLocation != null) {
                        map!!.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    mLocation!!.latitude,
                                    mLocation!!.longitude
                                ), 15f
                            )
                        )
                    } else {
                        val locationRequest = LocationRequest.create()
                        locationRequest.interval = 10000
                        locationRequest.fastestInterval = 5000
                        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                        val locationCallback = object : LocationCallback() {
                            override fun onLocationResult(locationResult: LocationResult) {
                                super.onLocationResult(locationResult)
                                mLocation = locationResult.lastLocation
                                map!!.moveCamera(
                                    CameraUpdateFactory.newLatLngZoom(
                                        LatLng(
                                            mLocation!!.latitude,
                                            mLocation!!.longitude
                                        ), 15f
                                    )
                                )
                                mFusedLocationProviderClient.removeLocationUpdates(locationCallback)
                            }
                        }
                        mFusedLocationProviderClient.requestLocationUpdates(
                            locationRequest,
                            locationCallback,
                            null
                        )
                    }
                }
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == mRequestCode) {
            if (resultCode == RESULT_OK) {
                getDeviceLocation()
            }
        }
    }

    private fun initSearchBar() {
        val searchBar: MaterialSearchBar = findViewById(R.id.searchBar1)
        searchBar.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener {
            override fun onButtonClicked(buttonCode: Int) {
                if (buttonCode == MaterialSearchBar.BUTTON_BACK) {
                    searchBar.disableSearch()
                }
            }
            override fun onSearchConfirmed(text: CharSequence?) {
                searchPlace(text)
            }
            override fun onSearchStateChanged(enabled: Boolean) {}
        })
    }

    private fun searchPlace(text: CharSequence?) {
        val geoCoder = Geocoder(applicationContext)

        try {
            val addressList = geoCoder.getFromLocationName(text.toString(), 1)
            if (addressList.isNotEmpty()) {
                val address: Address = addressList[0]
                val latLng = LatLng(address.latitude, address.longitude)
                map!!.addMarker(MarkerOptions().position(latLng).title(address.countryName))
                map!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            } else {
                Toast.makeText(this, "no place like this name", Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "you should connect to the internet", Toast.LENGTH_SHORT).show()
        }

    }

    fun getNearByMosques(view: View) {
        val rippleBg = findViewById<RippleBackground>(R.id.ripple_bg)
        rippleBg.startRippleAnimation()

        val location = "${mLocation!!.latitude}, ${mLocation!!.longitude}"
        val mapViewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        mapViewModel.getNearByMosques(type,location,getString(R.string.google_maps_key)).observe(this, Observer {
            if (it != null) {
                rippleBg.stopRippleAnimation()
                for (mosque in it) {
                    map!!.addMarker(
                        MarkerOptions().position(
                            LatLng(
                                mosque.geometry.location.lat,
                                mosque.geometry.location.lng
                            )
                        ).title(mosque.name)
                    )
                }
            }else{
                rippleBg.stopRippleAnimation()

                Toast.makeText(this,"error, please try again",Toast.LENGTH_LONG).show()
            }
        })
    }

    fun changeMapType(view: View) {
        when (map!!.mapType) {
            GoogleMap.MAP_TYPE_NORMAL -> map!!.mapType = GoogleMap.MAP_TYPE_SATELLITE
            GoogleMap.MAP_TYPE_SATELLITE -> map!!.mapType = GoogleMap.MAP_TYPE_HYBRID
            GoogleMap.MAP_TYPE_HYBRID -> map!!.mapType = GoogleMap.MAP_TYPE_NORMAL
        }
    }
}

