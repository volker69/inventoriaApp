package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.Config.Conexion
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.domain.lastProduct.LastProductServices

object LastProductDataSrc:LastProductServices {
    val retrofit = Conexion.retrofit

    private val services = retrofit.create(LastProductServices::class.java)
    override suspend fun getLasProduct(): ArrayList<LastProduct> {
     val response = services.getLasProduct()
        return response
    }

}