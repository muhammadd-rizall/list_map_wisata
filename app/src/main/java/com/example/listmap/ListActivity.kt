package com.example.listmap

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listmap.adapter.AdapterWisata
import com.example.listmap.model.ModelWisata

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        val listWisata = listOf(
            ModelWisata("Danau Maninjau",
                            "Tanjung Raya, Kabupaten Agam, Sumatera Barat,Indonesia",
                                         R.drawable.wisata1,
                            "Danau Maninjau adalah sebuah danau yang memiliki sejarah yang cukup unik. Berdasarkan sejarah, danau ini terbentuk akibat adanya letusan Gunung Api Sitinjau yang terjadi beribu-ribu tahun yang lalu.",
                                -0.3008159379174192,
                                100.19215935821015
            ),

            ModelWisata("Jam Gadang",
                            "Bukittinggi",
                                        R.drawable.wisata2,
                            "Jam Gadang adalah menara jam yang menjadi penanda atau ikon Kota Bukittinggi, Sumatera Barat, Indonesia. Menara jam ini menjulang setinggi 27 meter dan diresmikan pembangunannya pada 25 Juli 1927.[1] Terdapat jam berukuran besar berdiameter 80 cm di empat sisi menara sehingga dinamakan Jam Gadang, sebutan bahasa Minangkabau yang berarti jam besar.",
                -0.30514173448954246, 100.36951779031588
            ),

            ModelWisata("Danau Singkarak",
                            "Tanah Datar,Solok",
                                        R.drawable.wisata3,
                            "Danau Singkarak merupakan salah satu hasil dari proses tektonik yang dipengaruhi oleh Sesar Sumatra. Danau ini adalah bagian dari Cekungan Singkarak-Solok yang termasuk di antara segmen dari Sesar Sumatra. Cekungan dari danau ini terbentuk dari sebuah amblesan yang disebabkan oleh aktivitas pergerakan Sesar Sumatra. Cekungan besar ini terbendung oleh material vulkanik dari letusan gunung api sekitarnya. Akibat pembendungan material vulkanik ini terbentuklah Danau singkarak di satu bagian Cekungan Singkarak-Solok. Berbeda dengan Danau Maninjau yang terbentuk akibat letusan gunung api, Danau Singkarak terbentuk utamanya karena proses tektonik.",
                -0.5767434181815929, 100.53791816276332
            ),

            ModelWisata("Ngarai Sianok",
                            "Bukittinggi",
                                    R.drawable.wisata4,
                        "Ngarai Sianok merupakan sebuah lembah curam (jurang) yang terletak di perbatasan Kota Bukittinggi, di Kecamatan IV Koto, Kabupaten Agam, Sumatera Barat. Lembah ini memanjang dan berkelok sebagai garis batas kota dari selatan Ngarai Koto Gadang sampai ke nagari Sianok Anam Suku, dan berakhir di Kecamatan Palupuh. Ngarai Sianok memiliki pemandangan yang sangat indah dan juga menjadi salah satu objek wisata andalan provinsi.",
                -0.306832856589797, 100.36521006282732
            ),


            ModelWisata("Air Terjun Nyarai",
                            "Padang Pariaman",
                                R.drawable.wisata5,
                "Air Terjun Nyarai merupakan salah satu air terjun yang terletak di Kabupaten Padang Pariaman, Provinsi Sumatra Barat. Tepatnya di Dusun Gamaran, Nagari Salibutan, Kecamatan Lubuk Alung.\n" +
                        "Air terjun setinggi 8 meter ini terletak di kawasan Hutan Gamaran, Salibutan Lubuk Alung yang merupakan bagian dari Cagar Alam Nasional Bukit Barisan. Keindahan alam dan air terjunnya sudah banyak dinikmati para wisatawan.",
                -0.6829292255475085, 100.36307893956338)
        )

        val adapterWisata = AdapterWisata(listWisata)

        val rvWisata : RecyclerView = findViewById(R.id.rv_list)
        rvWisata.adapter = adapterWisata

        rvWisata.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}