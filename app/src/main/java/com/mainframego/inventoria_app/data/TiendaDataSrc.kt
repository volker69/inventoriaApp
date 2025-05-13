package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.Config.Conexion
import com.mainframego.inventoria_app.domain.tienda.Tienda
import com.mainframego.inventoria_app.domain.tienda.TiendaServices

object TiendaDataSrc:TiendaServices {

    val retrofit = Conexion.retrofit

    private val services = retrofit.create(TiendaServices::class.java)
    override suspend fun getTiendas():ArrayList<Tienda>{
        val response = services.getTiendas()
        return  response
    }

}