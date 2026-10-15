package com.example.shinyhunttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shinyhunttracker.ui.theme.ShinyHuntTrackerTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShinyHuntTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        ShinyHuntTrackerTitle()
                        Image(
                            painter = painterResource(R.drawable.cubone),
                            contentDescription = "Cubone sprite",
                            modifier = Modifier.size(160.dp),
                            contentScale = ContentScale.Fit
                        )
                        PokemonGameName("Emerald")
                        CurrentPokemonName("Cubone")
                        EncounterCounter(0)
                        Row() {
                            CounterButtonMinus()
                            CounterButtonPlus()
                        }
                    }

                }
            }
        }
    }
}

var currentHuntEncounters = 0

@Composable
fun CurrentPokemonName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Cubone",
        modifier = Modifier
    )
}

@Composable
fun ShinyHuntTrackerTitle(name: String = "Shiny Hunt Tracker", modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Composable
fun PokemonGameName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = Modifier
    )
}

@Composable
fun EncounterCounter(encounters: Int, modifier: Modifier = Modifier) {
    Text(
        text = "${encounters}",
        modifier = Modifier
    )
}

@Composable
fun CounterButtonPlus() {
    Button(onClick = {
        currentHuntEncounters++
        println("Encounters: ${currentHuntEncounters}")
    }) {
        Text(text = "+")
    }
}

@Composable
fun CounterButtonMinus() {
    Button(onClick = {
        if(currentHuntEncounters != 0) {
            currentHuntEncounters--
        }
        println("Encounters: ${currentHuntEncounters}")
    }) {
        Text(text = "-")
    }
}