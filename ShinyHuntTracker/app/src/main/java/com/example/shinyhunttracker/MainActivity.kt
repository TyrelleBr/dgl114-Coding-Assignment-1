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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShinyHuntTrackerTheme {
                EncounterCounterScreen()
            }
        }
    }
}

@Composable
fun CurrentPokemonName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
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
        modifier = modifier
    )
}

@Composable
fun EncounterCounter(encounters: Int, modifier: Modifier = Modifier) {
    Text(
        text = "${encounters}",
        modifier = modifier
    )
}

@Composable
fun CounterButtonPlus() {

    var encounters by remember {
        mutableIntStateOf(0)
    }


    Button(onClick = {
        encounters++
        println("Encounters: ${encounters}")
    }) {
        Text(text = "+")
    }
}

@Composable
fun EncounterCounterScreen() {
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
            Text(text = encounters.toString())
            Row() {
                CounterButtonPlus(fun () {
                    encounters++
                })
            }
        }

    }
}