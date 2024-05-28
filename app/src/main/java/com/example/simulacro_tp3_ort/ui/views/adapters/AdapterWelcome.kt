package com.example.simulacro_tp3_ort.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacro_tp3_ort.R
import com.example.simulacro_tp3_ort.ui.views.holders.HolderViewWelcome

class AdapterWelcome(private val images: List<Int>) : RecyclerView.Adapter<HolderViewWelcome>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderViewWelcome {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_item_welcome, parent, false)
        return HolderViewWelcome(view)
    }

    override fun onBindViewHolder(holder: HolderViewWelcome, position: Int) {
        val currentImage = images[position]

        holder.imageView.setImageResource(currentImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}