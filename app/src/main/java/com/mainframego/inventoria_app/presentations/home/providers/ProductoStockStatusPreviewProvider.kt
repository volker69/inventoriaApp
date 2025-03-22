package com.mainframego.inventoria_app.presentations.home.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioDetalleTotalStock

class ProductoStockStatusPreviewProvider:PreviewParameterProvider<InventarioDetalleTotalStock> {
    override val values:Sequence<InventarioDetalleTotalStock>
        get() = sequenceOf(
            InventarioDetalleTotalStock(
                productoId = 1,
                tienda = "Infalible",
                stockTotal = 30,
                producto = "Pantalon Cago")
        )
}