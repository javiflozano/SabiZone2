package com.iessanalberto.dam2.sabizone.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.sabizone.components.ProductCard
import com.iessanalberto.dam2.sabizone.data.allProducts
import com.iessanalberto.dam2.sabizone.data.cartList

@Composable
fun CartScreen(navController: NavController){
    LazyColumn (modifier = Modifier.fillMaxWidth().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp))
    {
        items(cartList) { product ->
            ProductCard(product = product, navController = navController)
        }
    }

}