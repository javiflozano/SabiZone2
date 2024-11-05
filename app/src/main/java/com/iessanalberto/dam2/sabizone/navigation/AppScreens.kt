package com.iessanalberto.dam2.sabizone.navigation

sealed class AppScreens(val route: String) {
    object ListScreen: AppScreens(route = "list_screen")
    object DetailScreen: AppScreens(route = "detail_screen")
    object CartScreen: AppScreens(route = "cart_screen")

}