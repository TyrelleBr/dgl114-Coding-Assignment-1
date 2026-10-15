package com.example.shinyhunttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.dec

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
        modifier = modifier,
        color = Color(0xFFEAF2FF),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ShinyHuntTrackerTitle(name: String = "Shiny Hunt Tracker", modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        color = Color(0xFF67E8F9),
        fontSize = 36.sp
    )
}

@Composable
fun PokemonGameName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        color = Color(0xFF9BAEC8),
        fontSize = 15.sp
    )
}

@Composable
fun CounterButtonPlus(onPlusClick: () -> Unit) {

    Button(onClick = onPlusClick
    ) {
        Text(
            text = "+",
            fontSize = 30.sp
        )
    }
}

@Composable
fun CounterButtonMinus(onMinusClick: () -> Unit) {
    Button(onClick = onMinusClick) {

        Text(
            text = "-",
            fontSize = 30.sp
        )
    }
}




@Composable
fun EncounterCounterScreen() {
    var encounters by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF0B1120)
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShinyHuntTrackerTitle()
            Column(
                
            ) {
                Image(
                    painter = painterResource(R.drawable.cubone),
                    contentDescription = "Cubone sprite",
                    modifier = Modifier.size(160.dp),
                    contentScale = ContentScale.Fit
                )
                CurrentPokemonName("Cubone")
                PokemonGameName("Pokemon Emerald")
            }
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFF131F35))
                    .padding(
                        start = 50.dp,
                        top = 8.dp,
                        end = 50.dp,
                        bottom = 16.dp
                    )

                    ,
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Text(
                    text = encounters.toString(),
                    color = Color(0xFFEAF2FF),
                    fontSize = 50.sp
                )
                Row() {

                    CounterButtonMinus(fun() {
                        if (encounters > 0) {
                            encounters--
                        }
                    })

                    CounterButtonPlus(fun() {
                        encounters++
                    })
                }
            }
        }

    }
}