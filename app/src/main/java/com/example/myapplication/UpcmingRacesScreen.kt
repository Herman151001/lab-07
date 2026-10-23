package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.*
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import  androidx.compose.ui.platform.testTag
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.*


@Composable
fun UpcomingRacesScreen(navController: NavController){
    var location by remember {
        mutableStateOf("")
    }

    var races = remember {
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // back button
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "Upcoming Races",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // text field and button to add race locations
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = location,
                onValueChange = {
                    location = it // update location to new value
                },
                label = {
                    Text("Race Location")
                },
                modifier = Modifier.testTag("locationInput") // for testing
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (location.isNotBlank()) {
                        races.add(location)
                        location = ""
                    }
                },
                modifier = Modifier.testTag("addRaceButton") // for testing
            ) {
                Text("Add")
            }
        }

        // list to display races
        LazyColumn {
            items(races) { race ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }
    }
}