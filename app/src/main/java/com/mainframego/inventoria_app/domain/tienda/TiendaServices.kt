package com.mainframego.inventoria_app.domain.tienda

import retrofit2.http.GET

interface TiendaServices {
    @GET("tienda")
    suspend fun getTiendas(): ArrayList<Tienda>
}