package com.mainframego.inventoria_app.presentations.home.components

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mainframego.inventoria_app.R
import com.mainframego.inventoria_app.InventoriaAppTheme
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.presentations.home.providers.LasrProductPreviewProvider


@Composable
fun LastProductCard(
    modifier: Modifier,
    lastProduct: LastProduct
){

    Card (
        modifier = Modifier
            .width(168.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column (
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = if (lastProduct.url_img.isNotEmpty()) lastProduct.url_img else R.drawable.imagen_emty,
                contentDescription = "Imagen del producto",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = lastProduct.nombre_producto,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Talla: ${lastProduct.talla}", fontSize = 14.sp, color = Color.Gray)
                Text(text = "Stock: ${lastProduct.stock}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true,
    uiMode =  android.content.res.Configuration.UI_MODE_NIGHT_NO)
@Composable
fun LastProductPreviewLight(
    @PreviewParameter(LasrProductPreviewProvider::class)lastProduct: LastProduct
){
    InventoriaAppTheme {
        LastProductCard(
            modifier = Modifier,
            lastProduct=lastProduct

        )
    }

}


