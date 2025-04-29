package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.domain.producto.Producto
import com.mainframego.inventoria_app.domain.producto.ProductoServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductoLocalDataSrc: ProductoServices {

    val retrofit = Conexion.retrofit

    private val services = retrofit.create(ProductoServices::class.java)
    override suspend fun getProducto(): ArrayList<Producto> {
        val response = services.getProducto()
        return response
    }

    override suspend fun postProducto(producto: Producto): Producto {
        val response = services.postProducto(producto)
        return response
    }


}