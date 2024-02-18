package com.example.colleagueclockin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.colleagueclockin.ui.navigation.Navigation
import com.example.colleagueclockin.ui.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun MyAppContent(navController: NavController) {
    // Content of MyAppContent goes here
    // ...

    // Navigate to MainScreen when the app is first launched
    LaunchedEffect(true) {
        navController.navigate(Screen.MainScreen.route)
    }

}





