package com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.makanan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Makanan
import kotlinx.android.synthetic.main.item_kuliner.view.*

class MakananAdapter(private val listMakanan: List<Makanan>) :
    RecyclerView.Adapter<MakananAdapter.MakananViewHolder>() {

    inner class MakananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Makanan) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(item.imgMakanan)
                    .into(imgKuliner)
                namaKuliner.text = item.nameMakanan
                aksaraKuliner.text = item.aksaraMakanan
                descIndoKuliner.text = item.descMakanan
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kuliner, parent, false)
        return MakananViewHolder(view)
    }

    override fun getItemCount(): Int = listMakanan.size

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        holder.bind(listMakanan[position])
    }

}