package com.iessanalberto.dam2.sabizone.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iessanalberto.dam2.sabizone.components.ProductDetailCard
import com.iessanalberto.dam2.sabizone.data.allProducts
import com.iessanalberto.dam2.sabizone.data.cartList
import com.iessanalberto.dam2.sabizone.navigation.AppScreens


@Composable
fun DetailScreen(navController: NavController, productName: String?){
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = {
                allProducts.find { it.name.equals(productName) }?.let { cartList.add(it) }
                navController.navigate(AppScreens.CartScreen.route)
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add to cart")
            }
        }
    ){
        paddingValues -> DetailBodyContent(productName = productName,
        navController = navController,
        modifier = Modifier.padding(paddingValues))
    }

}

@Composable
fun DetailBodyContent(productName: String?,navController: NavController,modifier: Modifier) {
    allProducts.find { it.name.equals(productName) }?.let { ProductDetailCard(product = it, navController = navController) }
}
