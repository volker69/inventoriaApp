package com.mainframego.inventoria_app.presentations.home.components

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mainframego.inventoria_app.InventoriaAppTheme
import com.mainframego.inventoria_app.domain.tienda.Tienda
import com.mainframego.inventoria_app.presentations.home.providers.TiendaPreviewProvider
import java.io.IOException

fun cargarImgDesdeAssets(context: Context, fileName: String) = try {
    val inputStream = context.assets.open(fileName)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    bitmap?.asImageBitmap()
} catch (e: IOException) {
    e.printStackTrace()
    null
}

@Composable
fun StoreCard(
    modifier: Modifier,
    tienda:Tienda,
    onClickCard:(Int)->Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickCard(tienda.tienda_id)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column( modifier = Modifier.padding(16.dp)) {
            Text(text = tienda.nombre_sucursal, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = tienda.direccion, fontWeight = FontWeight.Normal, fontSize = 15.sp )
        }
    }
}

@Preview(showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TiendaCardPreviewLight(
    @PreviewParameter(TiendaPreviewProvider::class)store:Tienda
){
    InventoriaAppTheme {
        StoreCard(
            modifier = Modifier,
            tienda = store,
            onClickCard = {}
        )
    }
}

@Preview(showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TiendaCardPreviewDark(
    @PreviewParameter(TiendaPreviewProvider::class)store:Tienda
){
    InventoriaAppTheme {
        StoreCard(
            modifier = Modifier,
            tienda = store,
            onClickCard = {}
        )
    }
}