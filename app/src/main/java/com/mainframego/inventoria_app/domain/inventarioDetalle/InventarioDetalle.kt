package com.mainframego.inventoria_app.domain.inventarioDetalle


import com.google.gson.annotations.SerializedName

data class InventarioDetalle(
    @SerializedName("producto_talla")
    val productoTallaIDT: ProductoTallaIDT,
    @SerializedName("stock")
    val stock: Int,
    @SerializedName("tienda")
    val tiendaIDT: TiendaIDT
)