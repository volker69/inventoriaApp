package com.mainframego.inventoria_app.domain.producto

import com.google.gson.annotations.SerializedName

data class Producto (
    @SerializedName("producto_id")
    val producto_id:Int?,
    @SerializedName("nombre")
    val nombre:String,
    @SerializedName("precio")
    val precio:Int?,
    @SerializedName("fecha_ingreso")
    val fecha_ingreso:String?
)