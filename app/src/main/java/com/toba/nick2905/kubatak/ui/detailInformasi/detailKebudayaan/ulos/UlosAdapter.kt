package com.toba.nick2905.kubatak.ui.detailInformasi.detailKebudayaan.ulos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Ulos
import kotlinx.android.synthetic.main.item_detail_hari.view.*

class UlosAdapter(private val listUlos: ArrayList<Ulos>) :
    RecyclerView.Adapter<UlosAdapter.UlosViewHolder>() {
    inner class UlosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ulos: Ulos) {
            with(itemView) {
                txtNamaHariBatak.text = ulos.ulosBatak
                txtAksaraHariBatak.text = ulos.ulosAksara
                txtArtiBatak.text = ulos.maknaBatak
                txtArtiIndonesia.text = ulos.maknaIndonesia
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UlosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_hari, parent, false)
        return UlosViewHolder(view)
    }

    override fun getItemCount(): Int = listUlos.size

    override fun onBindViewHolder(holder: UlosViewHolder, position: Int) {
        holder.bind(listUlos[position])
    }
}