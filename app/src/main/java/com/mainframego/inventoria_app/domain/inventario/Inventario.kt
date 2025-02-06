package com.mainframego.inventoria_app.domain.inventario


import com.google.gson.annotations.SerializedName

data class Inventario(
    @SerializedName("inventario_id")
    val inventarioId: Int,
    @SerializedName("producto_talla_id")
    val productoTallaId: Int,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("tienda_id")
    val tiendaId: Int
)