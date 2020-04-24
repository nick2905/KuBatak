package com.toba.nick2905.kubatak.ui.Kamus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toba.nick2905.kubatak.R
import com.toba.nick2905.kubatak.data.local.Kamus
import kotlinx.android.synthetic.main.item_kamus.view.*
import java.util.*
import kotlin.collections.ArrayList

class KamusAdapter(private val mContext: Context, private val modellist: ArrayList<Kamus>) : RecyclerView.Adapter<KamusAdapter.KamusViewHolder>() {
    val TYPE = 1
    var inflater = LayoutInflater.from(mContext)
    var tempModelList = ArrayList<Kamus>()

    inner class KamusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(kamus : Kamus){
            with(itemView){
                kamusBatak.text = kamus.kamusBatak
                artiKamusBatak.text = kamus.artiIndonesia
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KamusViewHolder {
        return when (viewType) {
            TYPE -> {
                val layoutview: View =
                    LayoutInflater.from(mContext).inflate(R.layout.item_kamus, parent, false)
                KamusViewHolder(layoutview)
            }
            else -> {
                val layoutview: View =
                    LayoutInflater.from(mContext).inflate(R.layout.item_kamus, parent, false)
                KamusViewHolder(layoutview)
            }
        }
    }

    override fun getItemCount(): Int = modellist.size

    override fun onBindViewHolder(holder: KamusViewHolder, position: Int) {
        holder.bind(modellist[position])
    }


    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        if (tempModelList.size < 1) {
            tempModelList.addAll(modellist)
        }
        modellist.clear()
        if (charText.length == 0) {
            modellist.addAll(tempModelList)
        } else {
            for (model in tempModelList) {
                if (model.kamusBatak.toLowerCase(Locale.getDefault())
                        .contains(charText)
                ) {
                    modellist.add(model)
                } else if (model.artiIndonesia.toLowerCase(Locale.getDefault())
                        .contains(charText)
                ) {
                    modellist.add(model)
                }
            }
        }
        notifyDataSetChanged()
    }
}