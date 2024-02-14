

package com.example.collegueclockin.ui.screens

import androidx.compose.runtime.Composable
import com.example.collegueclockin.viewmodels.CollegueListViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ItemListScreen() {


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

}
