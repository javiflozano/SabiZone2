package com.iessanalberto.dam2.sabizone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.sabizone.components.ProductCard
import com.iessanalberto.dam2.sabizone.data.allProducts
import com.iessanalberto.dam2.sabizone.models.Product
import com.iessanalberto.dam2.sabizone.navigation.AppScreens

@Composable
fun ListScreen(navController: NavController){
    Scaffold (floatingActionButton = {
        FloatingActionButton(onClick = {navController.navigate(AppScreens.CartScreen.route)}) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Shopping Cart")
        }
    })
    { paddingValues -> BodyContentListScreen(navController = navController, modifier = Modifier.padding(paddingValues))  }

}

@Composable
fun BodyContentListScreen(navController: NavController, modifier: Modifier) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var tipo by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Filtro")
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = tipo, onValueChange = { tipo = it }, label = { Text("Tipo") })
        LazyColumn (modifier = modifier.fillMaxWidth().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp))
        {
            items(allProducts.filter {
                filtrar(it, nombre, tipo)
            }) { product ->
                ProductCard(product = product, navController = navController)
            }
        }

    }
}

fun filtrar(it: Product, nombre: String, tipo: String): Boolean {
        if (nombre.isBlank() && tipo.isBlank()) return true // filtro vacío
        if (nombre.isNotBlank() && tipo.isBlank()) return it.name.startsWith(nombre)  //filtro por nombre
        if (tipo.isNotBlank() && nombre.isBlank()) return it.type.startsWith(tipo)  // filtro por tipo
        return it.name.startsWith(nombre) && it.type.startsWith(tipo) // filtro por nombre y tipo
}
