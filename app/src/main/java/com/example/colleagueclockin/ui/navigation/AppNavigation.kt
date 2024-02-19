package com.example.colleagueclockin.ui.navigation

import androidx.compose.runtime.Composable


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colleagueclockin.ui.screens.ItemListScreen
import com.example.colleagueclockin.ui.screens.MainAppContent


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainAppContent(navController = navController)
        }
        composable(
            route = Screen.ItemListScreen.route
        ) {
            ItemListScreen(navController = navController)
        }
    }
}