package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.domain.Producto
import com.mainframego.inventoria_app.domain.ProductoServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductoLocalDataSrc:ProductoServices {
    private val  url = "http://10.0.2.2:3000/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val services = retrofit.create(ProductoServices::class.java)
    override suspend fun getProducto(): ArrayList<Producto> {
        println("ARRANCANDO")
        val response = services.getProducto()
        println(response)
        return response
    }


}