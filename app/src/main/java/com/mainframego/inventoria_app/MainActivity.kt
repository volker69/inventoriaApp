package com.mainframego.inventoria_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mainframego.inventoria_app.data.ProductoLocalDataSrc
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.produceState
import com.mainframego.inventoria_app.data.InventarioLocalDataSrc
import com.mainframego.inventoria_app.data.InventarioStockTotalDataSrc
import com.mainframego.inventoria_app.data.LastProductDataSrc
import com.mainframego.inventoria_app.data.TiendaDataSrc
import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioDetalleTotalStock
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.domain.tienda.Tienda
import com.mainframego.inventoria_app.presentations.home.HomeDataState
import com.mainframego.inventoria_app.presentations.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InventoriaAppTheme {

                val dataStore by produceState (initialValue = emptyList<Tienda>()) {
                    value = TiendaDataSrc.getTiendas()//inventarioStockTotalDataSrc.getInventarioStockTotal()
                }
                val dataLastProduct by produceState(initialValue = emptyList<LastProduct>()) {
                    value = LastProductDataSrc.getLasProduct()
                }

                println("Valores de dataLastProduct $dataLastProduct")

                HomeScreen(
                    modifier = Modifier,
                    state = HomeDataState(title = "Pagina Principal",
                        cardStores = dataStore,
                        cardLastProduct = dataLastProduct

                    )
                )



            }
        }
    }

}

