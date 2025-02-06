package com.mainframego.inventoria_app.domain.inventarioDetalle


import com.google.gson.annotations.SerializedName

data class ProductoTallaIDT(
    @SerializedName("precio")
    val precio: Int,
    @SerializedName("producto")
    val producto: ProductoIDT,
    @SerializedName("talla")
    val talla: String
)