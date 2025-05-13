package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.Config.Conexion
import com.mainframego.inventoria_app.domain.inventario.Inventario
import com.mainframego.inventoria_app.domain.inventario.InventarioServices

object InventarioLocalDataSrc:InventarioServices {
    val retrofit = Conexion.retrofit
    private val services = retrofit.create(InventarioServices::class.java)
    override suspend fun getInventario():ArrayList<Inventario>{
        val response = services.getInventario()
        println(response)
        return response
    }

}