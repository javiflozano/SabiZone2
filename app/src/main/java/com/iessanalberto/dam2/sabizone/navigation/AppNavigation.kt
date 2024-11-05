package com.iessanalberto.dam2.sabizone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iessanalberto.dam2.sabizone.screens.CartScreen
import com.iessanalberto.dam2.sabizone.screens.DetailScreen
import com.iessanalberto.dam2.sabizone.screens.ListScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.ListScreen.route){
        composable(route = AppScreens.ListScreen.route) { ListScreen(navController = navController) }
        composable(route = AppScreens.DetailScreen.route + "/{productName}",
            arguments = listOf(navArgument(name = "productName") {type = NavType.StringType}))
            { DetailScreen(navController = navController, productName = it.arguments?.getString("productName"))}
        composable(route = AppScreens.CartScreen.route) { CartScreen(navController = navController) }
    }
}