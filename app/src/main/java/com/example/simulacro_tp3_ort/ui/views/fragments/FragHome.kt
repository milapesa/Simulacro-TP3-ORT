package com.example.simulacro_tp3_ort.ui.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacro_tp3_ort.R
import com.example.simulacro_tp3_ort.ui.views.adapters.DogsAdapter
import com.example.simulacro_tp3_ort.ui.views.entities.Dog
import com.example.simulacro_tp3_ort.ui.views.entities.DogImpl
import com.example.simulacro_tp3_ort.ui.views.entities.DogsImageResponse
import com.example.simulacro_tp3_ort.ui.views.services.PetApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragHome : Fragment() {
    lateinit var view1 : View
    lateinit var recyclerDogs : RecyclerView
    lateinit var manager : RecyclerView.LayoutManager
    lateinit var dogsAdapter : DogsAdapter
    lateinit var searcher : EditText

    val dogListWithText = addDogsWithText()
    val  dogList = getDogs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDogsWithText()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.lay_fragment_home, container, false)
        recyclerDogs = view1.findViewById(R.id.recyclerDogs)

        searcher =view1.findViewById(R.id.home_search)
        searcher.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
            }
        })

        return view1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerDogs.setHasFixedSize(true)
        manager = LinearLayoutManager(context)
        dogsAdapter = DogsAdapter(dogList)

        recyclerDogs.layoutManager = manager
        recyclerDogs.adapter = dogsAdapter
    }

    //se obtienen los perros de la api y se llama al metodo que los agrega a la lista
    private fun getDogs(): MutableList<Dog> {
        var list : MutableList<Dog> = ArrayList()
        val service = PetApiBuilder.create()

        service.getDogs().enqueue(object  : Callback<DogsImageResponse>{
            override fun onResponse(p0: Call<DogsImageResponse>, p1: Response<DogsImageResponse>) {
                if(p1.isSuccessful){
                    val response = p1.body()
                    for (i in 0 .. response!!.images.size-1){
                        addDog(response!!.images[i])
                    }

                }
            }

            override fun onFailure(p0: Call<DogsImageResponse>, p1: Throwable) {
                Log.e("Retrofit-error", p1.stackTraceToString())

            }

        })

        return list

    }

    //se generan perros con nombre y se agregan a una lista auxiliar
    fun addDogsWithText(): MutableList<Dog>{
        var dogWithText : MutableList<Dog> = ArrayList()

        dogWithText.add(Dog("Perro1", null, null, null))
        dogWithText.add(Dog("Perro2", null, null, null))
        dogWithText.add(Dog("Perro3", null, null, null))
        dogWithText.add(Dog("Perro4", null, null, null))

        return dogWithText
    }

    //se agregan perros a la lista y les agregamos nombre, raza y subraza
    //ademas se notifica al adapter que se agrego un perro y recarga la vista
    fun addDog(image: String) {
        var dogRandom = dogListWithText.random()
        dogList.add(Dog(dogRandom.name, image, DogImpl.getBreed(image), DogImpl.getSubBreed(image)))
        dogsAdapter.notifyDataSetChanged()
    }

    //funcion que filtra los perros por nombre
    private fun filter(text: String) {
        var filteredList: MutableList<Dog> = ArrayList()
        for (dog in dogList) {
            if (dog.name.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(dog)
            }
        }

        dogsAdapter.filter(filteredList)
    }

}