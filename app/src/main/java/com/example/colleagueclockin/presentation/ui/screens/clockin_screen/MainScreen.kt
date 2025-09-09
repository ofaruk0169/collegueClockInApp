package com.example.colleagueclockin.presentation.ui.screens.clockin_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.colleagueclockin.presentation.ui.navigation.Screen
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppContent(
    navController: NavController,
    viewModel: MainScreenViewModel = koinViewModel()
) {
    var password by remember { mutableStateOf("") }

    val colleagues = viewModel.colleagues
        .collectAsState(initial = emptyList())
        .value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Colleague Clock-in Application")} )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.ItemListScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Staff")
            }
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "An Omare Faruk Application",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            UserAddSignInSuccess(viewModel = viewModel)
            UserAddSignInError(viewModel = viewModel)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text("Sign In Code") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(IntrinsicSize.Min)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Add some spacing between TextField and Button

                Button(
                    onClick = {
                        viewModel.toggleClockInStatus(password)
                        password = ""
                    },
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Staff")
                }
            }
        }
    }
}


@Composable
fun UserAddSignInSuccess(viewModel: MainScreenViewModel) {
    val success = viewModel.success.collectAsState(initial = null).value
    val isClockIn = viewModel.isClockIn.collectAsState(initial = null).value

    if (success != null) {
        // Add debug logging
        println("Debug: success = $success, isClockIn = $isClockIn")

        val backgroundColor = if (isClockIn == true) {
            Color.Green // Clock IN = Green
        } else {
            Color.Red   // Clock OUT = Red
        }

        Box(
            modifier = Modifier
                .background(backgroundColor)
                .padding(8.dp)
        ) {
            Text(
                text = success,
                color = Color.White
            )
        }

        LaunchedEffect(Unit) {
            delay(5000)
            viewModel.clearSuccess()
        }
    }
}

@Composable
fun UserAddSignInError(viewModel: MainScreenViewModel) {
    val errorMessage = viewModel.signInError.collectAsState(initial = null).value

    if (errorMessage != null) {
        Box(
            modifier = Modifier
                .background(Color.Red) // Set the background color
                .padding(8.dp) // Set padding for better spacing
        ) {
            Text(
                text = errorMessage,
                color = Color.White // Set the text color
            )
        }

        // Launch coroutine to clear error after 5 seconds
        LaunchedEffect(Unit) {
            delay(5000)
            viewModel.clearSignInError()
        }
    }
}