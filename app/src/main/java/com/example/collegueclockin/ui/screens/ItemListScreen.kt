

package com.example.collegueclockin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.example.collegueclockin.viewmodels.CollegueListViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.collegueclockin.ui.navigation.Screen

@Composable
fun ItemListScreen() {

/*
    val viewModel: CollegueListViewModel = viewModel()

    // observing the list of items from the ViewModel
    val itemList by viewModel.collegues.collectAsState(initial = emptyList())

    // Display the list using LazyColumn
    LazyColumn {
        items(itemList.size) { index ->
            val item = itemList[index]
            // Each item in the list
            Text(text = "${item.firstName} ${item.lastName}")
        }
    }


 */

    //below is screen test

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

        Spacer(modifier = Modifier.height(46.dp))

        //Button layout

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

        }



        //submit button
        Button(
            onClick = {
                // Handle button 1 click
            },
            modifier = Modifier
                .height(66.dp)
                .padding(10.dp)
        ) {
            Text(text = "Enter")
        }
    }

}
