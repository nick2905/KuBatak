package com.toba.nick2905.kubatak.ui.detailPenomoran.hari

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Hari
import kotlinx.android.synthetic.main.item_detail_hari.view.*

class HariAdapter(private val listHari: ArrayList<Hari>) :
    RecyclerView.Adapter<HariAdapter.HariViewHolder>() {

    inner class HariViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hari: Hari){
            with(itemView){
                txtNamaHariBatak.text = hari.batakHari
                txtAksaraHariBatak.text = hari.aksaraHari
                txtArtiBatak.text = hari.batakArtiHari
                txtArtiIndonesia.text = hari.indonesiaArtiHari
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HariViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_hari, parent, false)
        return HariViewHolder(view)
    }

    override fun getItemCount(): Int = listHari.size

    override fun onBindViewHolder(holder: HariViewHolder, position: Int) {
        holder.bind(listHari[position])
    }
}