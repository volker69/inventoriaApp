package com.mainframego.inventoria_app.domain.inventarioDetalle

import retrofit2.http.GET

interface InvetarioDetalleServices {
    @GET("inventario/detalle")
    suspend fun getInventarioDetalle():ArrayList<InventarioDetalle>
}