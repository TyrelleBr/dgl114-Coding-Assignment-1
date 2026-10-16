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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.dec
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.platform.LocalConfiguration

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
        fontSize = 20.sp
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

    Button(
        onClick = onPlusClick,
        shape = RoundedCornerShape(12.dp)
    ) {

        Text(
            text = "+",
            fontSize = 30.sp
        )
    }
}

@Composable
fun CounterButtonMinus(onMinusClick: () -> Unit) {
    Button(
        onClick = onMinusClick,
        shape = RoundedCornerShape(12.dp)
    ) {

        Text(
            text = "-",
            fontSize = 30.sp
        )
    }
}




@Composable
fun EncounterCounterScreen() {

    var encounters by rememberSaveable() {
        mutableIntStateOf(0)
    }

    val configuration = LocalConfiguration.current

    var isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color(0xFF0B1120)
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.cubone),
                        contentDescription = "Cubone sprite",
                        modifier = Modifier.size(160.dp),
                        contentScale = ContentScale.Fit
                    )
                    CurrentPokemonName("Cubone")
                    PokemonGameName("Pokemon Fire Red")
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
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Text(
                        text = encounters.toString(),
                        color = Color(0xFFEAF2FF),
                        fontSize = 50.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

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
    } else {


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

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.cubone),
                        contentDescription = "Cubone sprite",
                        modifier = Modifier.size(160.dp),
                        contentScale = ContentScale.Fit
                    )
                    CurrentPokemonName("Cubone")
                    PokemonGameName("Pokemon Fire Red")
                }
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xFF131F35))
                        .padding(
                            start = 50.dp,
                            top = 8.dp,
                            end = 50.dp,
                            bottom = 16.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Text(
                        text = encounters.toString(),
                        color = Color(0xFFEAF2FF),
                        fontSize = 50.sp
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

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
}