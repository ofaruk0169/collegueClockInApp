package com.example.colleagueclockin.presentation.ui.navigation

import androidx.compose.runtime.Composable


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colleagueclockin.presentation.ui.screens.colleague_list.ItemListScreen
import com.example.colleagueclockin.presentation.ui.screens.clockin_screen.MainAppContent

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