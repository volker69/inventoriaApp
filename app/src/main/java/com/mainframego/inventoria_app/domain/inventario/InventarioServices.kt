package com.mainframego.inventoria_app.domain.inventario

import retrofit2.http.GET

interface InventarioServices {
    @GET("inventario")
    suspend fun getInventario():ArrayList<Inventario>
}