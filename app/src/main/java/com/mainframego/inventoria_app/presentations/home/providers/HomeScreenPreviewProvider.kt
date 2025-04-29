package com.mainframego.inventoria_app.presentations.home.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioDetalleTotalStock
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.domain.tienda.Tienda
import com.mainframego.inventoria_app.presentations.home.HomeDataState

class HomeScreenPreviewProvider:PreviewParameterProvider<HomeDataState> {
    override val values:Sequence<HomeDataState>
        get() = sequenceOf(
            HomeDataState(
                title = "Ulltimos productos",
                 cardStores = cardStore,
                cardLastProduct= cardLastProduct
            )
        )
}

val tiendaNombre:List<String> = listOf("Casa Matriz","Mall Plaza Norte local 345", "Porltal Lyon local 43","Dragstore Local 34");
val tiendaDescripcion:List<String> = listOf("Burgos 159","Av Vestpucio 234","AV Nueva Providencia 345","AV Nueva Providencia 298");
val productName:List<String> = listOf("Polera Azul","Cargo Jeas","Poleron Oversize")
val talla:List<String> = listOf("L","XL","S")
val stock:List<Int> = listOf(3,0,5)
val cardStore = mutableListOf<Tienda>()
    .apply {
        repeat(4){index ->add(
            Tienda(
                tienda_id = index+1,
                nombre_sucursal = tiendaNombre[index],
                direccion = tiendaDescripcion[index],
                comuna_id = index+1

            )
        )
        }
    }

val cardLastProduct = mutableListOf<LastProduct>()
    .apply {
        repeat(3){index->add(
            LastProduct(
                inventario_id = index+1,
                nombre_producto = productName[index],
                talla = talla[index],
                stock = stock[index],
                url_img = "",
                cdc_update = null,
                producto_id = 1
            )
        )

        }
    }