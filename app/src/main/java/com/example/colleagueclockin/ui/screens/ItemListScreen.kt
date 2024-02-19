

package com.example.colleagueclockin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import com.example.colleagueclockin.viewmodels.ColleagueListViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import databases.ColleagueEntity
import org.koin.androidx.compose.koinViewModel


@Composable
fun ItemListScreen(
    viewModel: ColleagueListViewModel = koinViewModel()
) {

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
        }
        viewModel.colleagueDetails?.let { details ->
            Dialog(onDismissRequest = viewModel::onColleagueDetailsDialogDismiss) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp),
                    //contentAlignment = Alignment.Center
                ) {
                    Text(text = "${details.firstName} ${details.lastName}")
                }
            }
        }
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
            .clickable { onItemClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = colleague.firstName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
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


