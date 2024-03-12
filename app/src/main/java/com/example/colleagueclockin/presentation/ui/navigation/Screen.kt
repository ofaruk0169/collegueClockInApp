package com.example.colleagueclockin.presentation.ui.navigation

sealed class Screen (val route: String) {
    object MainScreen: Screen("main_Screen")
    object ItemListScreen: Screen("ItemList_Screen")
}