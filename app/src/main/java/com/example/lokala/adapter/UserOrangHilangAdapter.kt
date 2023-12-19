package com.example.lokala.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lokala.R
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.UserOrangListItemBinding


class UserOrangHilangAdapter :
    ListAdapter<OrangHilangItem, UserOrangHilangAdapter.MyViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCalback: OnItemClickCalback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCalback) {
        this.onItemClickCalback = onItemClickCallback
    }


    class MyViewHolder(val binding: UserOrangListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OrangHilangItem) {

            with(binding) {
                Glide.with(binding.root.context)
                    .load(item.urlFoto[0])
                    .into(imUser)

                tvGender.text = item.gender
                tvUserName.text = item.nama
                tvLocation.text = item.kota

                if (item.isFound) {
                    tvResultStatus.setTextColor(
                        ContextCompat.getColor(itemView.context, R.color.green)
                    )
                    tvResultStatus.text = itemView.context.getString(R.string.ditemukan)
                } else {
                    tvResultStatus.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.red
                        )
                    )
                    tvResultStatus.text = itemView.context.getString(R.string.hilang)
                }


            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            UserOrangListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClickCalback.onItemClicked(item)
        }
        holder.bind(item)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<OrangHilangItem>() {
            override fun areItemsTheSame(oldItem: OrangHilangItem, newItem: OrangHilangItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: OrangHilangItem, newItem: OrangHilangItem): Boolean {
                return oldItem == newItem
            }

        }

    }

    interface OnItemClickCalback {

        fun onItemClicked(item: OrangHilangItem)

    }


}



