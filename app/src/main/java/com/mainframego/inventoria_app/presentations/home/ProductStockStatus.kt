package com.mainframego.inventoria_app.presentations.home

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mainframego.inventoria_app.InventoriaAppTheme
import com.mainframego.inventoria_app.R
import java.io.IOException

fun cargarImagenDesdeAssets(context: Context, fileName: String) = try {
    val inputStream = context.assets.open(fileName)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    bitmap?.asImageBitmap()
} catch (e: IOException) {
    e.printStackTrace()
    null
}

@Composable
fun StockCard(
    productName: String,
    stock: Int,
    isCritical: Boolean,
    imageRes: Int? = null // Permite pasar una imagen opcional
) {
    var stockView:String = stock.toString();
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp)
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
                Text(text = productName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(text ="Stock :", fontWeight = FontWeight.Bold)
                    Text(text =stockView,Modifier.padding(
                        horizontal = 5.dp
                    ))
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text ="Stock Critico",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun StockCardPreview(){
    InventoriaAppTheme {
        StockCard(productName = "Jeans Cargo",
            stock = 20,
            isCritical = true,
            imageRes = null)
    }
}