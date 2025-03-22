package com.mainframego.inventoria_app.domain.inventarioDetalle


import com.google.gson.annotations.SerializedName

data class InventarioDetalleTotalStock(
    @SerializedName("producto")
    val producto: String,
    @SerializedName("producto_id")
    val productoId: Int,
    @SerializedName("stock_total")
    val stockTotal: Int,
    @SerializedName("tienda")
    val tienda: String
)