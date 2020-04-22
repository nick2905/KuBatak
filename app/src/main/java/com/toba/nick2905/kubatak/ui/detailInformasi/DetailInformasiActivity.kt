package com.toba.nick2905.kubatak.ui.detailInformasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Kebudayaan
import com.toba.nick2905.kubatak.data.local.Kesusastraan
import com.toba.nick2905.kubatak.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail_informasi.*

class DetailInformasiActivity : AppCompatActivity() {
    private lateinit var adapterKebudayaanAdapter: KebudayaanAdapter
    private var listBudaya = ArrayList<Kebudayaan>()

    private lateinit var adapterKesusastraanAdapter: KesusastraanAdapter
    private var listSastra = ArrayList<Kesusastraan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_informasi)

        rvKebudayaanInformasi.setHasFixedSize(true)
        rvKesusastraan.setHasFixedSize(true)

        listBudaya.addAll(getListBudaya())
        listSastra.addAll(getListSastra())

        showRecyclerKebudayaan()
        showRecyclerKesusastraan()

        backImageInformasi.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun getListBudaya(): ArrayList<Kebudayaan>{
        val dataNameKebudayaan = resources.getStringArray(R.array.name_informasi_kebudayaan)
        val dataDescKebudayaan = resources.getStringArray(R.array.desc_informasi_kebudayaan)

        val listKebudayaan = ArrayList<Kebudayaan>()

        for(position in dataDescKebudayaan.indices){
            val budaya = Kebudayaan(
                dataNameKebudayaan[position],
                dataDescKebudayaan[position]
            )
            listKebudayaan.add(budaya)
        }
        return listKebudayaan
    }

    private fun getListSastra(): ArrayList<Kesusastraan>{
        val dataNameKesusastraan = resources.getStringArray(R.array.name_informasi_kesusastraan)
        val dataDescKesusastraan = resources.getStringArray(R.array.desc_informasi_kesusastraan)

        val listSastraAll = ArrayList<Kesusastraan>()

        for(position in dataDescKesusastraan.indices){
            val sastra = Kesusastraan(
                dataNameKesusastraan[position],
                dataDescKesusastraan[position]
            )
            listSastraAll.add(sastra)
        }
        return listSastraAll
    }

    private fun showRecyclerKebudayaan(){
        rvKebudayaanInformasi.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterKebudayaanAdapter = KebudayaanAdapter(listBudaya)
        rvKebudayaanInformasi.adapter = adapterKebudayaanAdapter
    }

    private fun showRecyclerKesusastraan(){
        rvKesusastraan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterKesusastraanAdapter = KesusastraanAdapter(listSastra)
        rvKesusastraan.adapter = adapterKesusastraanAdapter
    }

    //onBackPress
    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
