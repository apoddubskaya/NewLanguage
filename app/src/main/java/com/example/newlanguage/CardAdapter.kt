package com.example.newlanguage

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(val values: List<Card>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.card_text)
        val translation: TextView = itemView.findViewById(R.id.card_translation)
        val image: ImageView = itemView.findViewById(R.id.card_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = values[position].text
        holder.translation.text = values[position].translation
        if (values[position].imageResourceID != null) {
            holder.image.visibility = View.VISIBLE
            holder.image.setImageResource(values[position].imageResourceID!!)
        }
        else
            holder.image.visibility = View.GONE
    }
}
