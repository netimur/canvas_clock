package com.netimur.clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.netimur.clock.ui.theme.Typography
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var time by remember {
                mutableStateOf(LocalTime.now())
            }

            LaunchedEffect(Unit) {
                while (true) {
                    delay(1000L)
                    time = time.plusSeconds(1)
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 20.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                item {
                    Text(text = "Time is: ${time.format(formatter)}", style = Typography.bodyLarge)

                }

                itemsIndexed(TimeZoneCity.entries) { index, city ->
                    var time by remember {
                        mutableStateOf(getTimeForCity(city))
                    }
                    LaunchedEffect(Unit) {
                        while (true) {
                            delay(1000L)
                            time = time.plusSeconds(1)
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Text(
                            text = "Time in ${city.nativeName}: ${time.format(formatter)}",
                            style = Typography.bodyLarge
                        )

                        Clock(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            style = clocks.getOrElse(
                                index = index,
                                defaultValue = { darkElegance }),
                            initialTime = time
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainPreview() {
    Clock(modifier = Modifier.fillMaxSize(), style = ClockStyle())
}