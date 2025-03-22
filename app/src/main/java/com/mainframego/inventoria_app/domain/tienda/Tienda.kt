package com.mainframego.inventoria_app.domain.tienda

import com.google.gson.annotations.SerializedName

data class Tienda(
    @SerializedName("tienda_id")
    val tienda_id:Int,
    @SerializedName("nombre_sucursal")
    val nombre_sucursal:String,
    @SerializedName("direccion")
    val direccion:String,
    @SerializedName("comuna_id")
    val  comuna_id:Int?
)