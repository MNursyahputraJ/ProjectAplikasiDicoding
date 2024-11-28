package com.example.projectakhir

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ListB2EAdapter (private val listB2E: ArrayList<Anggota>) :
    RecyclerView.Adapter<ListB2EAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_keluarga_balabala,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int =listB2E.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listB2E[position]
        holder.imgitemphoto.setImageResource(photo)
        holder.tvnameitem.text = name
        holder.tvitemdescription.text = description
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailAnggota::class.java)
            intent.putExtra(DetailAnggota.EXTRA_NAME, name)
            intent.putExtra(DetailAnggota.EXTRA_DESCRIPTION, description)
            intent.putExtra(DetailAnggota.EXTRA_PHOTO, photo)
            context.startActivity(intent)

            Toast.makeText(context, "Kamu memilih $name", Toast.LENGTH_SHORT).show()
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgitemphoto :ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvnameitem :TextView = itemView.findViewById(R.id.tv_name_item)
        val tvitemdescription : TextView = itemView.findViewById(R.id.tv_item_description)
    }


}