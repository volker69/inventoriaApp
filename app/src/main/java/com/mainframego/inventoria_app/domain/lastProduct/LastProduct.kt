package com.mainframego.inventoria_app.domain.lastProduct

import com.google.gson.annotations.SerializedName

data class LastProduct (
    @SerializedName("nombre_producto")
    var nombre_producto:String,
    @SerializedName("talla")
    var talla:String,
    @SerializedName("url_img")
    var url_img:String,
    @SerializedName("stock")
    var stock:Int,
    @SerializedName("cdc_update")
    var cdc_update:String?,
    @SerializedName("inventario_id")
    var inventario_id:Int?
)