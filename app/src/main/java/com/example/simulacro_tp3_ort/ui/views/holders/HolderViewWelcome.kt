package com.example.simulacro_tp3_ort.ui.views.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacro_tp3_ort.R

class HolderViewWelcome(itemView : View) : RecyclerView.ViewHolder(itemView){

    val imageView : ImageView

    init {
        imageView = itemView.findViewById(R.id.imageWelcome)
    }
}
