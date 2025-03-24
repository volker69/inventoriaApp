package com.mainframego.inventoria_app.domain.lastProduct

import retrofit2.http.GET
import retrofit2.http.Path

interface LastProductServices {
    @GET("producto/last")
    suspend fun getLasProduct():ArrayList<LastProduct>
}