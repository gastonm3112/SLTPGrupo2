package com.example.hpapplicationtp.endpoints

import com.example.hpapplicationtp.dtos.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {

    // Endpoint para obtener todos los personajes
    @GET("api/characters")
    fun getAllCharacters(): Call<List<Post>>

    // Si la API permite buscar por nombre, usamos el parámetro de query
    @GET("api/characters")
    fun getCharacterByName(@Query("name") name: String): Call<List<Post>>
}
