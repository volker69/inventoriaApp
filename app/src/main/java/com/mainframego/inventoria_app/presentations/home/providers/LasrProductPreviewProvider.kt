package com.mainframego.inventoria_app.presentations.home.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct

class LasrProductPreviewProvider:PreviewParameterProvider<LastProduct> {
    override val values: Sequence<LastProduct>
        get() = sequenceOf(
            LastProduct(
                nombre_producto = "Cargo jeans",
                talla = "L",
                stock = 4,
                url_img = "",
                cdc_update = null,
                inventario_id = 1,
                producto_id = 1
            )
        )
}