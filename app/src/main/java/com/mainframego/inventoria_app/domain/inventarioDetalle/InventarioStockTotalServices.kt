package com.mainframego.inventoria_app.domain.inventarioDetalle

import retrofit2.http.GET

interface InventarioStockTotalServices {
    @GET("inventario/detalle-stock")
    suspend fun getInventarioStockTotal():ArrayList<InventarioDetalleTotalStock>
}