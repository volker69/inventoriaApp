package com.mainframego.inventoria_app.domain.tienda

import retrofit2.http.GET
import retrofit2.http.Headers
import com.mainframego.inventoria_app.Config.Auth
interface TiendaServices {


    @GET("tienda")
    suspend fun getTiendas(): ArrayList<Tienda>
}