package com.example.myapplication
import androidx.navigation.NavController
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import  androidx.compose.ui.platform.testTag



@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FormulaZero Home",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("races")
            },
            modifier = Modifier.testTag("raceButton") // for testing
        ) {
            Text("Upcoming Races")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("drivers")
            },
            modifier = Modifier.testTag("driverButton") // for testing
        ) {
            Text("FormulaZero Driver")
        }
    }
}