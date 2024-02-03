package com.example.collegueclockin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegueclockin.ui.theme.CollegueClockInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollegueClockInTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppContent()
                }
            }
        }
    }
}

@Composable
fun MyAppContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Colleague Clock-in Application"
        )

        Spacer(modifier = Modifier.height(66.dp))

        //Button layout

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    // Handle button 1 click
                },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text(text = "Sign In")
            }

            Button(
                onClick = {
                    // Handle button 2 click
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Staff Status")
            }
        }




    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CollegueClockInTheme {
        MyAppContent()
    }
}