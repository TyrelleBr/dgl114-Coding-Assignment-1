package com.example.shinyhunttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shinyhunttracker.ui.theme.ShinyHuntTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShinyHuntTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShinyHuntTrackerTitle()
                    CounterButtonPlus()
                }
            }
        }
    }
}

@Composable
fun ShinyHuntTrackerTitle(name: String = "Shiny Hunt Tracker", modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Composable
fun CounterButtonPlus() {
    Button(onClick = {
        println("plus button clicked")
    }) {
        Text(text = "+")
    }
}