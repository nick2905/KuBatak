package com.toba.nick2905.kubatak.ui.detailPenomoran.hari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Hari
import kotlinx.android.synthetic.main.activity_detail_hari.*

class DetailHari : AppCompatActivity() {
    private lateinit var adapterHari: HariAdapter
    private var listHari = ArrayList<Hari>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hari)

        rvHari.setHasFixedSize(true)
        listHari.addAll(getListHari())

        showRecyclerHari()

    }

    private fun getListHari(): ArrayList<Hari> {
        val dataHariBatak = resources.getStringArray(R.array.name_hari_batak)
        val dataAksaraHari = resources.getStringArray(R.array.name_hari_aksara)
        val dataArtiBatakHari = resources.getStringArray(R.array.desc_arti_hari)
        val dataArtiIndonesiaHari = resources.getStringArray(R.array.desc_lapatan_hari)

        val listAllHari = ArrayList<Hari>()
        for (position in dataHariBatak.indices) {
            val hari = Hari(
                dataHariBatak[position],
                dataAksaraHari[position],
                dataArtiBatakHari[position],
                dataArtiIndonesiaHari[position]
            )
            listAllHari.add(hari)
        }
        return listAllHari
    }

    private fun showRecyclerHari() {
        rvHari.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterHari = HariAdapter(listHari)
        rvHari.adapter = adapterHari
    }
}
