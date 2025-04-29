package com.mainframego.inventoria_app.presentations.producto.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputTextProduct(modifier: Modifier = Modifier, placeholder: String) {


        Box(modifier = modifier) {
        var texto by remember { mutableStateOf("") }

        TextField(value = placeholder, onValueChange = { texto = it }, label = { Text("Escribe algo") })
        }
 }

