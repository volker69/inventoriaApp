package com.mainframego.inventoria_app.presentations.producto.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mainframego.inventoria_app.InventoriaAppTheme


@Composable
fun LabelProduct(modifier: Modifier,texto:String){
    Box {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = modifier
                .padding(8.dp)

        )
    }
}

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
fun LabelProductPreviewLight(){
    InventoriaAppTheme {
        LabelProduct(
            modifier = Modifier,
            texto = "HOLA"
        )
    }
}

@Composable
@Preview(
    showBackground = false,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
fun LabelProductPreviewDark(){
    InventoriaAppTheme {
        LabelProduct(
            modifier = Modifier,
            texto = "HOLA"
        )
    }
}