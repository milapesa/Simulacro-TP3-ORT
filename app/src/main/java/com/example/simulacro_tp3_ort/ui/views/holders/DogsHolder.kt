package com.example.simulacro_tp3_ort.ui.views.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacro_tp3_ort.R

class DogsHolder(v : View) : RecyclerView.ViewHolder(v){
    private var view : View

    init {
        this.view = v
    }

    fun setImage(image : String?){
        val itemImage = view.findViewById<ImageView>(R.id.card_dog_image)
        Glide.with(view.context).load(image).centerCrop().into(itemImage)
    }

    fun setName(name : String?){
        val itemName = view.findViewById<TextView>(R.id.card_dog_name)
        itemName.text = name
    }

    fun setBreed(breed: String?){
        val itemBreed = view.findViewById<TextView>(R.id.card_dog_breed)
        itemBreed.text = breed
    }

    fun setSubBreed(subBreed: String?){
        val itemSubBreed = view.findViewById<TextView>(R.id.card_dog_subBreed)
        itemSubBreed.text = subBreed
    }

    fun getItem() = view.findViewById<CardView>(R.id.card_dog)
}