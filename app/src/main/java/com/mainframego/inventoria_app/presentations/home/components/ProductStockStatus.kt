package com.mainframego.inventoria_app.presentations.home.components

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mainframego.inventoria_app.InventoriaAppTheme
import com.mainframego.inventoria_app.R
import com.mainframego.inventoria_app.domain.inventarioDetalle.InventarioDetalleTotalStock
import com.mainframego.inventoria_app.presentations.home.providers.ProductoStockStatusPreviewProvider
import java.io.IOException



@Composable
fun StockCard(
    modifier: Modifier,
    inventarioDetalleTotalStock: InventarioDetalleTotalStock,
    isCritical: Boolean,
    onClickCard:(Int)->Unit

) {
    var stockView:String = inventarioDetalleTotalStock.stockTotal.toString()//stock.toString();
    Card(
        modifier = Modifier
            .clickable {
                onClickCard(inventarioDetalleTotalStock.productoId)
            }
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),

    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id= R.drawable.imagen_emty),
                contentDescription = "Imagen vacia",
                modifier = Modifier.size(70.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = inventarioDetalleTotalStock.producto, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    if (inventarioDetalleTotalStock.stockTotal==0){
                        Text(text = if (inventarioDetalleTotalStock.stockTotal==0)  "Sin Stock" else "",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error)
                    }else{
                        Text(text ="Stock :", fontWeight = FontWeight.Bold)
                        Text(text =stockView,Modifier.padding(
                            horizontal = 5.dp
                        ))
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    if (inventarioDetalleTotalStock.stockTotal>0)
                    {
                        Text(text = if (isCritical)  "Stock Critico" else "",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.error)
                    }

                }
            }
        }

    }
}

@Preview(showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun StockCardPreviewLight(
    @PreviewParameter(ProductoStockStatusPreviewProvider::class)inventarioDetalleTotalStock:InventarioDetalleTotalStock
){
    InventoriaAppTheme {
        StockCard(
            modifier = Modifier,
            inventarioDetalleTotalStock = inventarioDetalleTotalStock,
            isCritical = true,
            onClickCard = {}

        )

    }
}


@Preview(showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun StockCardPreviewDark(
    @PreviewParameter(ProductoStockStatusPreviewProvider::class)inventarioDetalleTotalStock:InventarioDetalleTotalStock
){
    InventoriaAppTheme {
        StockCard(
            modifier = Modifier,
            inventarioDetalleTotalStock = inventarioDetalleTotalStock,
            isCritical = true,
            onClickCard = {}

        )

    }
}