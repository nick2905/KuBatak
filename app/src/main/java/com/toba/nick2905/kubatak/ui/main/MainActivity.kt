package com.toba.nick2905.kubatak.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Mataangin
import com.toba.nick2905.kubatak.data.local.Numbering
import com.toba.nick2905.kubatak.ui.detailInformasi.DetailInformasiActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapterNumbering: NumberingAdapter
    private var listNumber = ArrayList<Numbering>()

    private lateinit var adapterMata: MataAdapter
    private var listMata = ArrayList<Mataangin>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNumberingMain.setHasFixedSize(true)
        rvMataAnginMain.setHasFixedSize(true)

        listNumber.addAll(getListNumbering())
        listMata.addAll(getListMata())

        showRecyclerNumbering()
        showRecyclerMata()

        lnrInformasiBatak.setOnClickListener {
            startActivity(Intent(this, DetailInformasiActivity::class.java))
            finish()
        }
    }

    private fun showRecyclerNumbering() {
        rvNumberingMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterNumbering = NumberingAdapter(listNumber)
        rvNumberingMain.adapter = adapterNumbering
    }

    private fun showRecyclerMata() {
        rvMataAnginMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterMata = MataAdapter(listMata)
        rvMataAnginMain.adapter = adapterMata
    }

    private fun getListNumbering(): ArrayList<Numbering> {
        val dataNameNumbering = resources.getStringArray(R.array.name_penomoran)
        val dataDescNumbering = resources.getStringArray(R.array.deskripsi_penomoran)

        val listNumber = ArrayList<Numbering>()

        for (position in dataNameNumbering.indices) {
            val number = Numbering(
                dataNameNumbering[position],
                dataDescNumbering[position]
            )
            listNumber.add(number)
        }
        return listNumber
    }

    private fun getListMata(): ArrayList<Mataangin> {
        val dataBatakMata = resources.getStringArray(R.array.name_mata_angin_batak)
        val dataBahasaMata = resources.getStringArray(R.array.name_mata_angin)
        val dataAksaraMata = resources.getStringArray(R.array.name_mata_angin_aksara)

        val listMata = ArrayList<Mataangin>()

        for (position in dataBatakMata.indices) {
            val mata = Mataangin(
                dataBahasaMata[position],
                dataAksaraMata[position],
                dataBatakMata[position]
            )
            listMata.add(mata)
        }
        return listMata
    }
}
