package com.mainframego.inventoria_app.data

import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioDetalleTotalStock
import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioStockTotalServices

object InventarioStockTotalDataSrc:InventarioStockTotalServices {
    val retrofit = Conexion.retrofit
    private val services = retrofit.create(InventarioStockTotalServices::class.java)
    override suspend fun getInventarioStockTotal(): ArrayList<InventarioDetalleTotalStock> {
        val response = services.getInventarioStockTotal();
        return response
    }
}