package com.example.listmap.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.listmap.DetailWisataMapsActivity
import com.example.listmap.R
import com.example.listmap.model.ModelWisata

class AdapterWisata(
    val itemList : List<ModelWisata>

): RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //layout pada widget
        val itemGambar : ImageView = itemView.findViewById(R.id.imgWisata)
        val itemNama : TextView = itemView.findViewById(R.id.txtNamaWisata)
        val itemLokasi : TextView = itemView.findViewById(R.id.txtLokasiWisata)
        val cardWisata : CardView = itemView.findViewById(R.id.cardWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_wisata, parent,false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemGambar.setImageResource(currentItem.gambarWisata)
        holder.itemNama.setText(currentItem.NamaLokasiWisata)
        holder.itemLokasi.setText(currentItem.AlamatWisata)

        //event klik pada card view
        holder.cardWisata.setOnClickListener(){
            val inten = Intent(holder.itemView.context,DetailWisataMapsActivity::class.java)
            //kirim data list item wisata ke detail wisata activitei
            inten.putExtra("NamaLokasiWisata",currentItem.NamaLokasiWisata)
            inten.putExtra("gambarWisata",currentItem.gambarWisata)
            inten.putExtra("Deskripsi",currentItem.deskripsiWisata)
            inten.putExtra("latWisata",currentItem.latWisata)
            inten.putExtra("longWisata",currentItem.longWisata)

            //menjalankan inten startActivity
            holder.itemView.context.startActivity(inten)
        }
    }

}