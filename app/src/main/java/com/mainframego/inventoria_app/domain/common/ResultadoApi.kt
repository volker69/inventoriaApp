package com.mainframego.inventoria_app.domain.common

sealed class ResultadoApi<out T> {
    data class Exito<T>(val data: T): ResultadoApi<T>()
    data class Error(val mensaje: String): ResultadoApi<Nothing>()
    object Cargando : ResultadoApi<Nothing>()
}