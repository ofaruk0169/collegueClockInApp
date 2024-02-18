

package com.example.collegueclockin.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import com.example.collegueclockin.viewmodels.CollegueListViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel



@Composable
fun ItemListScreen(
    viewModel: CollegueListViewModel = koinViewModel()
) {

    val itemList by viewModel.collegues.collectAsState(initial = emptyList())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

    }





    /*    val viewModel: CollegueListViewModel = koinViewModel()
        // observing the list of items from the ViewModel
        val itemList by viewModel.collegues.collectAsState(initial = emptyList())

        // Display the list using LazyColumn
        LazyColumn {
            items(itemList.size) { index ->
                val item = itemList[index]
                // Each item in the list
                Text(text = "${item.firstName} ${item.lastName}")
            }
        }*/



}


