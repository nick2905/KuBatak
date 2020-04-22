package com.toba.nick2905.kubatak.ui.detailInformasi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Kesusastraan
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKesusastraan.AnakSurat.DetailAnakSurat
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKesusastraan.InaSurat.DetailInaSurat
import com.toba.nick2905.kubatak.ui.detailInformasi.detailKesusastraan.SuratBatak.DetailSuratBatak
import kotlinx.android.synthetic.main.item_detail_batak.view.*

class KesusastraanAdapter(private val listKesusastraan: ArrayList<Kesusastraan>) :
    RecyclerView.Adapter<KesusastraanAdapter.KesusastraanViewHolder>() {
    inner class KesusastraanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sastra: Kesusastraan) {
            with(itemView){
                nameBatakDetail.text = sastra.judul
                descBatakDetail.text = sastra.desc
                itemView.setOnClickListener {
                    when (layoutPosition) {
                        0 -> context.startActivity(Intent(this.context, DetailSuratBatak::class.java))
                        1 -> context.startActivity(Intent(this.context, DetailInaSurat::class.java))
                        2 -> context.startActivity(Intent(this.context, DetailAnakSurat::class.java))
                        else -> {
                            Toast.makeText(context,"Sabar yah, kontennya belum ada.",Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KesusastraanViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_batak, parent, false)
        return KesusastraanViewHolder(view)
    }

    override fun getItemCount(): Int = listKesusastraan.size

    override fun onBindViewHolder(holder: KesusastraanViewHolder, position: Int) {
        holder.bind(listKesusastraan[position])
    }

}