package com.example.hpapplicationtp.configurations

import com.example.hpapplicationtp.endpoints.PostService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.Moshi

object RetrofitClient {

    private const val BASE_URL = "https://hp-api.onrender.com/" // URL base correcta

    private val moshi: Moshi by lazy {
        Moshi.Builder().build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val postService: PostService by lazy {
        retrofit.create(PostService::class.java)
    }
}
