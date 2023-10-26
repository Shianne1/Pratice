package com.example.studentattendencepratice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentattendencepratice.ui.theme.StudentAttendencePraticeTheme
import com.example.studentattendencepratice.ui.theme.clickGoldButton
import com.example.studentattendencepratice.ui.theme.clickRandomButton
import com.example.studentattendencepratice.ui.theme.clickTotalButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list2 = FileReader.readFile(this, "Attendace")
            StudentAttendencePraticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Header(name = "STUDENT'S ATTENDANCE")
                   // CategoryList(list = list2)
                   // HeaderAndFooter(list = list2)
                    HomeScreen(list = list2)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(list: ArrayList<StudentNames>){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page"){
            HeaderAndFooter(list = list, navController = navController )
        }

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderAndFooter(list: ArrayList<StudentNames>, navController: NavController){
    Scaffold(
        topBar =  {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    //.padding(top = 30.dp)
                    .height(120.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.Blue,
                ),
                title = {
                    Row(
                        modifier = Modifier
                            .padding(top = 25.dp, bottom = 10.dp)
                            //.width(600.dp)
                            //.background(color = Color.Yellow, shape = RectangleShape),
                    ) {
                        TextButton( onClick = { /*TODO*/ }) {
                            Text(
                                text = "STUDENT'S ATTENDANCE",
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            )
            {
                Row( modifier = Modifier
                    .fillMaxWidth(),
                    //.background(color = Color.Yellow, shape = RectangleShape),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { navController.navigate("total_count")  }) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Total Count",
                        )
                    }
                    Button(onClick = { navController.navigate("gold_star") }) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Gold Stars",
                        )
                    }
                    Button(onClick = { navController.navigate("random_student") }) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Random Student",
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        StudentList(list = list, paddingValues = innerPadding)
    }
}