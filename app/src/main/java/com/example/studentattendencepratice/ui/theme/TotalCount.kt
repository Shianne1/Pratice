package com.example.studentattendencepratice.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page") {
        composable("total_count"){
            clickTotalButton(navController = navController)
        }

        composable("gold_star") {
            clickGoldButton(navController = navController)
        }

        composable("random_student"){
            clickRandomButton(navController = navController)
        }
    }
}

@Composable
fun clickTotalButton(navController: NavController){
    Card(modifier = Modifier
        .height(220.dp)
        .width(200.dp)
        .background(color = Color.Yellow, shape = RectangleShape)
    ) {

        Button(modifier = Modifier
            //.padding(top = 30.dp)
            .height(120.dp)
            .width(100.dp),
            //.background(color = Color.Yellow, shape = RectangleShape) ,
            onClick = { navController.navigate("home_page") }) {
            Text(
                textAlign = TextAlign.Center,
                text = "Total Count",
            )
        }
        /*
        Surface(
            modifier = Modifier
                //.padding(top = 30.dp)
                .height(220.dp)
                .width(200.dp)
                .background(color = Color.Yellow, shape = RectangleShape)

        ) {
            Button(modifier = Modifier
                //.padding(top = 30.dp)
                .height(120.dp)
                .width(100.dp),
                //.background(color = Color.Yellow, shape = RectangleShape) ,
                onClick = { navController.navigate("home_page") }) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Total Count",
                )
            }
        }

         */
    }

}

@Composable
fun clickGoldButton(navController: NavController) {
    Surface(
        modifier = Modifier
            //.padding(top = 30.dp)
            .height(120.dp)
            .width(100.dp)
            .background(color = Color.Cyan, shape = RectangleShape)

    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Total Count",
        )
    }
    Button(onClick = { navController.navigate("home_page") }) {
        Text(
            textAlign = TextAlign.Center,
            text = "Gold Stars",
        )
    }
}

@Composable
fun clickRandomButton(navController: NavController){
    Surface(
        modifier = Modifier
            //.padding(top = 30.dp)
            .height(120.dp)
            .width(100.dp)
            .background(color = Color.Green, shape = RectangleShape)

    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Total Count",
        )
    }
    Button(onClick = { navController.navigate("home_page") }) {
        Text(
            textAlign = TextAlign.Center,
            text = "Random Student",
        )
    }
}