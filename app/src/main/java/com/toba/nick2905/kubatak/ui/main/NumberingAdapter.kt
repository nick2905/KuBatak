package com.toba.nick2905.kubatak.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Numbering
import com.toba.nick2905.kubatak.ui.detailPenomoran.angka.DetailAngka
import com.toba.nick2905.kubatak.ui.detailPenomoran.bulan.DetailBulan
import com.toba.nick2905.kubatak.ui.detailPenomoran.hari.DetailHari
import com.toba.nick2905.kubatak.ui.detailPenomoran.jam.DetailJam
import kotlinx.android.synthetic.main.item_main_numbering.view.*

class NumberingAdapter(private val listNumber: ArrayList<Numbering>) :
    RecyclerView.Adapter<NumberingAdapter.NumberingViewHolder>() {

    inner class NumberingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(number: Numbering) {
            with(itemView) {
                nameNumbering.text = number.name
                descNumbering.text = number.desc
                itemView.setOnClickListener {
                    when (layoutPosition) {
                        0 -> context.startActivity(Intent(this.context, DetailAngka::class.java))
                        1 -> context.startActivity(Intent(this.context, DetailJam::class.java))
                        2 -> context.startActivity(Intent(this.context, DetailHari::class.java))
                        3 -> context.startActivity(Intent(this.context, DetailBulan::class.java))
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_numbering, parent, false)
        return NumberingViewHolder(view)
    }

    override fun getItemCount(): Int = listNumber.size

    override fun onBindViewHolder(holder: NumberingViewHolder, position: Int) {
        holder.bind(listNumber[position])
    }

}