package com.mainframego.inventoria_app.domain

import retrofit2.http.GET

interface ProductoServices {
  @GET("producto")
  suspend fun getProducto():ArrayList<Producto>
}