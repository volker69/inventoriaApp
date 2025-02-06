package com.mainframego.inventoria_app.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Conexion {
    const val LOCAL = "http://10.0.2.2:3000/api/"
    private val  url = LOCAL
     val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}