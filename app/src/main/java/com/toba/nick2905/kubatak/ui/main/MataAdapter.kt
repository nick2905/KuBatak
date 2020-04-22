package com.toba.nick2905.kubatak.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Mataangin
import kotlinx.android.synthetic.main.item_main_compass.view.*

class MataAdapter(private val listMata: ArrayList<Mataangin>) :
    RecyclerView.Adapter<MataAdapter.MataViewHolder>() {

    inner class MataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mata: Mataangin) {
            with(itemView) {
                nameBatakMata.text = mata.namaBatakMataangin
                nameBahasaMata.text = mata.namaBahasaMataangin
                nameAksaraMata.text = mata.namaAksaraMataangin
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MataViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_compass, parent, false)
        return MataViewHolder(view)
    }

    override fun getItemCount(): Int = listMata.size

    override fun onBindViewHolder(holder: MataViewHolder, position: Int) {
        holder.bind(listMata[position])
    }

}