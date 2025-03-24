@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.mainframego.inventoria_app.presentations.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.mainframego.inventoria_app.InventoriaAppTheme
import com.mainframego.inventoria_app.R
import com.mainframego.inventoria_app.domain.lastProduct.LastProduct
import com.mainframego.inventoria_app.domain.tienda.Tienda
import com.mainframego.inventoria_app.presentations.home.components.LastProductCard
import com.mainframego.inventoria_app.presentations.home.components.SectionTitle
import com.mainframego.inventoria_app.presentations.home.components.StoreCard
import com.mainframego.inventoria_app.presentations.home.providers.HomeScreenPreviewProvider

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state:HomeDataState,
){
    var isMenuExtend by remember { mutableStateOf(false) }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    Box(
                        modifier = Modifier.padding(8.dp).clickable {
                            isMenuExtend = true
                        }
                    ){
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Agregar Productos",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                        DropdownMenu(
                            expanded = isMenuExtend,
                            modifier =  Modifier.background(
                                color = MaterialTheme.colorScheme.surfaceContainerHigh
                            ),
                            onDismissRequest = {isMenuExtend= false}
                        ) {
                            DropdownMenuItem(
                                text ={
                                    Text(
                                        text =stringResource(R.string.ver_tiendas),
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                },

                                onClick = {}
                            )
                        }
                    }
                }
            )
        },
        content = {
            paddingValues ->
               Column (

               ){
                   LazyColumn( modifier = Modifier.padding( paddingValues = paddingValues )
                       .padding(horizontal = 13.dp),
                       verticalArrangement = Arrangement.spacedBy(5.dp
                       )){
                       stickyHeader {
                           SectionTitle(
                               modifier = Modifier
                                   .fillParentMaxWidth()
                                   .background(
                                       color = MaterialTheme.colorScheme.surface
                                   ),
                               title = stringResource(R.string.soculsales)
                           )
                       }
                       items(state.cardStores, key = {
                               tiendas->tiendas.tienda_id
                       }){
                               store->
                           StoreCard(modifier=Modifier,tienda=store, onClickCard = {})
                       }
                   }
                   Box(){
                       SectionTitle(
                           modifier = Modifier
                               .background(
                                   color = MaterialTheme.colorScheme.surface
                               )
                               .padding(horizontal = 13.dp),
                           title = stringResource(R.string.ultimos_Productos)
                       )
                       LazyRow( modifier = Modifier.padding( paddingValues = paddingValues )
                           .padding(horizontal = 5.dp),
                           horizontalArrangement = Arrangement.spacedBy(
                               1.dp)) {
                           stickyHeader {
                           }
                           items(state.cardLastProduct, key = {
                                   lastProduct->lastProduct.inventario_id
                           }){
                                   lastProduct ->
                               LastProductCard(modifier=Modifier,lastProduct=lastProduct)
                           }
                       }
                   }
               }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar producto")
            }
        }
    )
}

@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenPreviewDark(
    @PreviewParameter(HomeScreenPreviewProvider::class) state: HomeDataState
){
    InventoriaAppTheme {
        HomeScreen(
            state = HomeDataState(
                title = state.title,
                cardStores = state.cardStores ,
                cardLastProduct = state.cardLastProduct
            )
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeScreenPreviewLight(
    @PreviewParameter(HomeScreenPreviewProvider::class) state: HomeDataState
){
    InventoriaAppTheme {
        HomeScreen(
            state = HomeDataState(
                title = state.title,
                cardStores = state.cardStores ,
                cardLastProduct = state.cardLastProduct
            )
        )
    }
}



data class HomeDataState(
    val title:String,
    val cardStores: List<Tienda>,
    val cardLastProduct:List<LastProduct>
)