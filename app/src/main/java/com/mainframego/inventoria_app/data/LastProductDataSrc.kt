package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.domain.lastProduct.LastProductServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object LastProductDataSrc:LastProductServices {
    val retrofit = Conexion.retrofit

    private val services = retrofit.create(LastProductServices::class.java)
    override suspend fun getLasProduct(): ArrayList<LastProduct> {
     val response = services.getLasProduct()
        return response
    }

}