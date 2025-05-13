package com.mainframego.inventoria_app.Config

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Conexion {
    const val LOCAL = "http://10.0.2.2:3000/api/"
    const val DEV = "http://147.182.241.85:8080/api/"
    private val url = LOCAL

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(client) // aquí usamos el cliente con el interceptor
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}