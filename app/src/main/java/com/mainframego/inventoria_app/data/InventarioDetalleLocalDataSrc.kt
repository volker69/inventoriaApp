package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioDetalle
import com.mainframego.inventoria_app.domain.inventarioDetalle.InvetarioDetalleServices

object InventarioDetalleLocalDataSrc:InvetarioDetalleServices {
    val retrofit = Conexion.retrofit
    private val services = retrofit.create(InvetarioDetalleServices::class.java)
    override suspend fun getInventarioDetalle(): ArrayList<InventarioDetalle> {
        val response = services.getInventarioDetalle()
        return response
    }
}