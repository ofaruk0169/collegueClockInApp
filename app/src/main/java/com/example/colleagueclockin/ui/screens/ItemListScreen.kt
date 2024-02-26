

package com.example.colleagueclockin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.material3.TextField
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import com.example.colleagueclockin.viewmodels.ColleagueListViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.colleagueclockin.ui.navigation.Screen
import databases.ColleagueEntity
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation


@Composable
fun ItemListScreen(
    navController: NavController,
    viewModel: ColleagueListViewModel = koinViewModel()
) {

    //collect data here from viewmodel
    val colleagues = viewModel.colleagues
        .collectAsState(initial = emptyList())
        .value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(colleagues) { colleague ->
                    ColleagueItem (
                        colleague = colleague,
                        onItemClick = {
                                      viewModel.getColleagueById(colleague.id)
                        },
                        onDeleteClick = {
                            viewModel.onDeleteClick(colleague.id)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }



            if(viewModel.error != null) { 
                Text(text = viewModel.error ?: "")
            }





            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = {
                    navController.navigate(Screen.MainScreen.route)
                }) {
                    Text("Clock In/Out")
                }

                Button(onClick = {
                    viewModel.addStaff()
                }) {
                    Text("Add Staff")
                }
            }
        }

        //person detail dialog

        if (viewModel.showInputDialog.value) {
            Dialog(
                onDismissRequest = {
                    viewModel.addStaffDismiss()
                    // Perform any other cleanup or actions needed when the dialog is dismissed
                },
                content = {
                    // Content of the dialog
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Text("Add Staff")

                        Spacer(modifier = Modifier.height(16.dp))

                        // Your input fields or other content here

                        TextField(
                            value = viewModel.firstNameText,
                            onValueChange = viewModel::onFirstNameChange,
                            placeholder = { Text("Enter Staff First Name") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        TextField(
                            value = viewModel.lastNameText,
                            onValueChange = viewModel::onLastNameChange,
                            placeholder = { Text("Enter Staff Second Name") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        TextField(
                            value = viewModel.pinText,
                            onValueChange = viewModel::onPinChange,
                            placeholder = { Text("Enter Staff Pin") },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        TextField(
                            value = viewModel.pinReenterText,
                            onValueChange = viewModel::onPinReenterChange,
                            placeholder = { Text("Re-enter Pin") },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            // Button to confirm adding staff
                            Button(
                                onClick = {
                                    // Add logic to handle adding staff here
                                    viewModel.onInsertColleagueClick()
                                }
                            ) {
                                Text("Add")
                            }

                            // Button to manually dismiss the dialog
                            Button(
                                onClick = {
                                    viewModel.addStaffDismiss()
                                }
                            ) {
                                Text("Dismiss")
                            }
                        }

                    }
                }
            )
        }
        //end of person detail dialog.

        //Colleague's details
        viewModel.colleagueDetails?.let { details ->
            Dialog(onDismissRequest = viewModel::onColleagueDetailsDialogDismiss) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp),
                    //contentAlignment = Alignment.Center
                ) {
                    Text(text = "${details.firstName} ${details.lastName} ")
                }
            }
        }

        //End of colleague's details.

    }
}

@Composable
fun ColleagueItem (
    colleague: ColleagueEntity,
    onItemClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onItemClick() }
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = colleague.firstName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Shift Status",
            modifier = Modifier.weight(1f)

        )
        Checkbox(
            checked = colleague.clockInStatus == 1L,
            onCheckedChange = {  },
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onDeleteClick) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete person",
                tint = Color.Gray
            )
        }
    }
}