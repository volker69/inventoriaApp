package com.mainframego.inventoria_app.presentations.home.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mainframego.inventoria_app.domain.tienda.Tienda

class TiendaPreviewProvider:PreviewParameterProvider <Tienda>{
    override val values: Sequence<Tienda>
        get() = sequenceOf(
            Tienda(
                tienda_id = 1,
                nombre_sucursal = "Mall Plaza Norte Local 320",
                direccion = "Av vespucio 234",
                comuna_id = 2
            )
        )
}