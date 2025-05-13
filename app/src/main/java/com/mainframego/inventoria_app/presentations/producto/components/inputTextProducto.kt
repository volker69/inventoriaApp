package com.mainframego.inventoria_app.presentations.producto.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.mainframego.inventoria_app.InventoriaAppTheme
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.presentations.home.components.LastProductCard
import com.mainframego.inventoria_app.presentations.home.providers.LasrProductPreviewProvider

@Composable
fun InputTextProduct(modifier: Modifier = Modifier, placeholder: String,titulo:String) {


        Box(modifier = modifier) {
            var text by remember { mutableStateOf(placeholder) }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(titulo) },
                textStyle = TextStyle(color = Color.Gray)
            )

            /*var texto = remember { mutableStateOf("") }
            TextField(value = placeholder, onValueChange = { texto = texto}, label = { Text("Escribe algo") })
            */
        }



 }

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
fun InputTextProductoPreviewDark(){
    InventoriaAppTheme {
        InputTextProduct(placeholder = "Esto es un titulo", titulo = "TITULOS")
    }
}

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
fun InputTextProductoPreviewLight(){
    InventoriaAppTheme {
        InputTextProduct(placeholder = "Esto es un titulo", titulo = "TITULOS")
    }
}





