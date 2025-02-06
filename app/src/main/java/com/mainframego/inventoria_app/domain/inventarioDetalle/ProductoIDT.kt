package com.mainframego.inventoria_app.domain.inventarioDetalle


import com.google.gson.annotations.SerializedName

data class ProductoIDT(
    @SerializedName("nombre")
    val nombre: String
)