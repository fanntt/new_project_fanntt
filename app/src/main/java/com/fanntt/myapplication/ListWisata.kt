package com.fanntt.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanntt.myapplication.adapter.AdapterWisata
import com.fanntt.myapplication.model.ModelWisata

class ListWisata : AppCompatActivity() {
    private var recyleView : RecyclerView? = null
    private var wisatalist =  mutableListOf<ModelWisata>()
    private var wisataAdapter : AdapterWisata? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        wisatalist = ArrayList()

        recyleView = findViewById(R.id.rv_wisata)
        wisataAdapter = AdapterWisata(this,wisatalist);

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(
            this,1
        )
        recyleView!!.layoutManager = layoutManager
        recyleView!!.adapter =wisataAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        preparedDataWisata()
    }

    private fun preparedDataWisata() {
        var wisata = ModelWisata(
            R.drawable.wisata1,
            "Istana Pagaruyung",
            "Batusangkar",
            -0.47140736248392395, 100.62109205809485

        )
        wisatalist.add(wisata)
        wisata = ModelWisata(
            R.drawable.wisata2,
            "Lembah Harau",
            "Kabupaten Lima Puluh Kota",
            -0.1131130842398401, 100.66968166498198

        )
        wisatalist.add(wisata)
        wisata = ModelWisata(
            R.drawable.wisata3,
            "Masjid Raya Sumbar",
            "Kota Padang",
            -0.9246362686820684, 100.36226704477477
        )
        wisatalist.add(wisata)
        wisata = ModelWisata(
            R.drawable.wisata4,
            "Nagari Pariangan",
            "Tanah Datar",
            -0.44548510399484526, 100.4838114325477
        )
        wisatalist.add(wisata)
        wisata = ModelWisata(
            R.drawable.wisata5,
            "Ngarai Sianok",
            "Bukittinggi",
            -0.3079882822017007, 100.3651052912989
        )
        wisatalist.add(wisata)
        wisataAdapter!!.notifyDataSetChanged()
    }
}