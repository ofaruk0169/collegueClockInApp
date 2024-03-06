package com.example.colleagueclockin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.colleagueclockin.ui.navigation.Screen
import com.example.colleagueclockin.viewmodels.ColleagueListViewModel
import com.example.colleagueclockin.viewmodels.MainScreenViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainAppContent(
    navController: NavController,
    viewModel: MainScreenViewModel = koinViewModel()
) {

    var password by remember { mutableStateOf("") }

    val colleagues = viewModel.colleagues
        .collectAsState(initial = emptyList())
        .value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Colleague Clock-in Application"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    // navigate to ItemListScreen when clicked.
                    navController.navigate(Screen.ItemListScreen.route)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Staff Status")
            }
        }

        UserAddSignInSuccess(viewModel = viewModel)

        UserAddSignInError(viewModel = viewModel)


        //Password input
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
                .fillMaxWidth()
                .padding(top = 16.dp),
        )

        //submit button
        Button(
            onClick = {
                viewModel.toggleClockInStatus(password)
                password = ""
            },
            modifier = Modifier
                .height(66.dp)
                .padding(10.dp)
        ) {
            Text(text = "Enter")
        }
    }
}

@Composable
fun UserAddSignInSuccess(viewModel: MainScreenViewModel) {
    val success = viewModel.success.collectAsState(initial = null).value

    if (success != null) {
        Box(
            modifier = Modifier
                .background(Color.Green) // Set the background color
                .padding(8.dp) // Set padding for better spacing
        ) {
            Text(
                text = success,
                color = Color.White // Set the text color
            )
        }

        // Launch coroutine to clear error after 5 seconds
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