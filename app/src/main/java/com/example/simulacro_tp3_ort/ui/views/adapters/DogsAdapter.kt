package com.example.simulacro_tp3_ort.ui.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacro_tp3_ort.R
import com.example.simulacro_tp3_ort.ui.views.entities.Dog
import com.example.simulacro_tp3_ort.ui.views.holders.DogsHolder

class DogsAdapter (
    var dogs : MutableList<Dog>,

    ) : RecyclerView.Adapter<DogsHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_dog, parent, false)
        return DogsHolder(view)
    }

    override fun getItemCount() = dogs.size

    override fun onBindViewHolder(holder: DogsHolder, position: Int) {
        val dog = dogs[position]
        holder.setImage(dog.image)
        holder.setName(dog.name)
        holder.setBreed(dog.breed)
        holder.setSubBreed(dog.subBreed)
    }

    fun filter(filteredList: MutableList<Dog>) {
        this.dogs = filteredList
        notifyDataSetChanged()

    }

}