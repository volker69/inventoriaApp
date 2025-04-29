package com.mainframego.inventoria_app.domain.producto

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductoServices {
  @GET("producto")
  suspend fun getProducto():ArrayList<Producto>

  @POST("producto")
  suspend fun postProducto(@Body producto: Producto):Producto

}