package com.mainframego.inventoria_app.presentations.producto.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mainframego.inventoria_app.InventoriaAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(
    textFieldState:TextFieldState,
    onSearch:(String)->Unit,
    searchResults:List<String>,
    modifier: Modifier =Modifier
){
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ){
        SearchBar(
            modifier=Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldState.text.toString(),
                    onQueryChange = {textFieldState.edit { replace(0,length,it) }},
                    onSearch={
                        onSearch(textFieldState.text.toString())
                        expanded=false
                    },
                    expanded = expanded,
                    onExpandedChange = {expanded = it},
                    placeholder = { Text("Buscar...") }
                )
            },
            expanded = expanded,
            onExpandedChange = {expanded = it}
        ) {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                searchResults.forEach {  result ->
                    ListItem(
                        headlineContent = { Text(result) },
                        modifier = Modifier
                            .clickable {
                                textFieldState.edit { replace(0, length, result) }
                            }
                            .fillMaxSize()
                    )
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewSearchComponent() {
    // Estado simulado para el TextField
    val textFieldState = rememberTextFieldState("")

    // Lista de resultados de prueba
    val dummyResults = listOf("Producto 1", "Producto 2", "Producto 3")

    InventoriaAppTheme {
        // Componente en sí
        SearchComponent(
            textFieldState = textFieldState,
            onSearch = { /* acción simulada */ },
            searchResults = dummyResults,
            modifier = Modifier.padding(16.dp)
        )
    }
}
