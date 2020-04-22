package com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.makanan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Makanan
import kotlinx.android.synthetic.main.activity_detail_makanan.*

class DetailMakanan : AppCompatActivity() {
    private val listMakanan: MutableList<Makanan> = mutableListOf()
    private lateinit var adapterMakanan: MakananAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_makanan)

        rvMakanan.setHasFixedSize(true)
        listMakanan.addAll(getListMakanan())
        showRecyclerMakanan()

    }


    private fun getListMakanan(): ArrayList<Makanan> {
        val dataNameMakanan = resources.getStringArray(R.array.name_makanan_batak)
        val dataAksaraMakanan = resources.getStringArray(R.array.name_makanan_aksara)
        val dataDescMakanan = resources.getStringArray(R.array.desc_makanan_batak)
        val dataImage = resources.obtainTypedArray(R.array.img_makanan_batak)

        val listMakananAll = ArrayList<Makanan>()
        listMakanan.clear()
        for (i in 0 until dataImage.length()) {
            val makanan = Makanan(
                dataImage.getResourceId(i, 0),
                dataNameMakanan[i],
                dataAksaraMakanan[i],
                dataDescMakanan[i]
            )

            listMakananAll.add(makanan)
        }
        dataImage.recycle()
        return listMakananAll
    }

    private fun showRecyclerMakanan() {
        rvMakanan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterMakanan = MakananAdapter(listMakanan)
        rvMakanan.adapter = adapterMakanan
    }
}
