package com.fanntt.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailWisata : AppCompatActivity() {

    private lateinit var detailnama : TextView
    private lateinit var detaillokasi : TextView
    private lateinit var detailimg : ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)

        button=findViewById(R.id.btnlokasi)
        detailnama=findViewById(R.id.txtDetailnama)
        detaillokasi=findViewById(R.id.txtDetailLokasi)
        detailimg=findViewById(R.id.imgDetailWisata)

        //get data langitude longitude
        val Detailnama = intent.getStringExtra("NamaWisata")
        val DetailLokasi = intent.getStringExtra("LokasiWisata")
        val DetailImg = intent.getIntExtra("ImgWisata",0)
        val langitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude",0.0)

        detailnama.setText(Detailnama)
        detaillokasi.setText(DetailLokasi)
        detailimg.setImageResource((DetailImg))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button.setOnClickListener(){
            val intentMenu2 = Intent(this@DetailWisata,
                MapsActivity::class.java)
            //put longitude latitude
            intentMenu2.putExtra("latitude",langitude)
            intentMenu2.putExtra("longitude",longitude)
            startActivity(intentMenu2)
        }
    }
}