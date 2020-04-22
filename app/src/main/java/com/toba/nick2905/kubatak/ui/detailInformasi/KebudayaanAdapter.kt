package com.toba.nick2905.kubatak.ui.detailInformasi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Kebudayaan
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.bendera.DetailBendera
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.kepercayaan.DetailKepercayaan
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.makanan.DetailMakanan
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.sejarah.DetailSejarah
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.ulos.DetailUlos
import kotlinx.android.synthetic.main.item_detail_batak.view.*

class KebudayaanAdapter(private val listKebudayaan: ArrayList<Kebudayaan>) :
    RecyclerView.Adapter<KebudayaanAdapter.KebudayaanViewHolder>() {
    inner class KebudayaanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(budaya: Kebudayaan) {
            with(itemView) {
                nameBatakDetail.text = budaya.nameDetailBatak
                descBatakDetail.text = budaya.descDetailBatak
                itemView.setOnClickListener {
                    when (layoutPosition) {
                        0 -> context.startActivity(Intent(this.context, DetailSejarah::class.java))
                        1 -> context.startActivity(Intent(this.context, DetailBendera::class.java))
                        2 -> context.startActivity(Intent(this.context, DetailUlos::class.java))
                        3 -> context.startActivity(Intent(this.context, DetailKepercayaan::class.java))
                        4 -> context.startActivity(Intent(this.context, DetailMakanan::class.java))
                        else -> {
                            Toast.makeText(context,"Sabar yah, kontennya belum ada.", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KebudayaanViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_batak, parent, false)
        return KebudayaanViewHolder(view)
    }

    override fun getItemCount(): Int = listKebudayaan.size

    override fun onBindViewHolder(holder: KebudayaanViewHolder, position: Int) {
        holder.bind(listKebudayaan[position])
    }

}