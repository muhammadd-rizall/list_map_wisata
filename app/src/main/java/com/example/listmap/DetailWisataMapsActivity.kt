package com.example.listmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.listmap.databinding.ActivityDetailWisataMapsBinding

class   DetailWisataMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDetailWisataMapsBinding
    private lateinit var tvNamaLokasiWisata : TextView
    private lateinit var imgwisata : ImageView
    private lateinit var tvDeskripsi : TextView
    private lateinit var btnWisata : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityDetailWisataMapsBinding.inflate(layoutInflater)
     setContentView(binding.root)

        tvNamaLokasiWisata = findViewById(R.id.tvNamaLokasiWisata)
        imgwisata = findViewById(R.id.imgwisata)
        tvDeskripsi = findViewById(R.id.tvDeskripsi)
        btnWisata = findViewById(R.id.btnWisata)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //mengambil data dari intent
        val NamaLokasiWisata = intent.getStringExtra("NamaLokasiWisata")
        val gambarWisata = intent.getIntExtra("gambarWisata",0)
        val Deskripsi = intent.getStringExtra("Deskripsi")
        val latWisata = intent.getDoubleExtra("latWisata",0.0)
        val longWisata = intent.getDoubleExtra("longWisata",0.0)


        tvNamaLokasiWisata.text = NamaLokasiWisata
        imgwisata.setImageResource(gambarWisata)
        tvDeskripsi.text = Deskripsi

        btnWisata.setOnClickListener{
            val intentMapWisata = Intent(this,MapsActivity::class.java)
            //kirim lat dan long
            intentMapWisata.putExtra("latWisata",latWisata)
            intentMapWisata.putExtra("longWisata",longWisata)
            intentMapWisata.putExtra("NamaLokasiWisata",NamaLokasiWisata)
            startActivity(intentMapWisata)
        }

        // Add a marker in Sydney and move the camera
        val KoordinatWisata = LatLng(-latWisata, longWisata)
        mMap.addMarker(MarkerOptions().position(KoordinatWisata).title("NamaLokasiWisata"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KoordinatWisata, 14f))
    }
}