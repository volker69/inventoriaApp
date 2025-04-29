package com.mainframego.inventoria_app.domain.producto

import com.google.gson.annotations.SerializedName

data class Producto (
    @SerializedName("producto_id")
    val producto_id:Int?,
    @SerializedName("nombre_producto")
    val nombre:String,
    @SerializedName("descripcion")
    val descripcion:String?,
    @SerializedName("url_img")
    val url_img:String?,
    @SerializedName("pruductoi_id_jumpselller")
    val pruductoi_id_jumpselller:String?,
    @SerializedName("estado")
    val estado:Boolean?
)

/*
export interface IProduct{
    producto_id?: number;
    nombre_producto: string;
    descripcion: string;
    url_img: string;
    pruductoi_id_jumpselller?: number;
    estado:boolean;
}
* */