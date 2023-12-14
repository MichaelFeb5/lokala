package com.example.lokala.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lokala.R
import com.example.lokala.data.dummy.OrangHilang

class OrangHilangAdapter(
    private val context: Context,
    private val orangHilang: List<OrangHilang>,
) : RecyclerView.Adapter<OrangHilangAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.orang_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(orangHilang[position].url_foto[0]).into(holder.ivOrang)
        holder.tvNama.text = orangHilang[position].nama
        holder.tvGender.text =
            "${orangHilang[position].umur} tahun, ${orangHilang[position].tinggi} cm, ${orangHilang[position].gender}"
        holder.tvKota.text = orangHilang[position].kota


        holder.itemView.setOnClickListener {
            onItemClickListener?.onClick(holder.ivOrang, orangHilang[position])
        }
    }

    override fun getItemCount(): Int {
        return orangHilang.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivOrang: ImageView = itemView.findViewById(R.id.iv_orang)
        val tvNama: TextView = itemView.findViewById(R.id.tv_nama)
        val tvGender: TextView = itemView.findViewById(R.id.tv_gender)
        val tvKota: TextView = itemView.findViewById(R.id.tv_kota)
    }

    interface OnItemClickListener {
        fun onClick(ivOrangHilang: ImageView, region: OrangHilang) {

        }
    }
}