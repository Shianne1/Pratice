package com.example.studentattendencepratice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentattendencepratice.ui.theme.Amaranth
import com.example.studentattendencepratice.ui.theme.Background_Color
import com.example.studentattendencepratice.ui.theme.Bittersweet
import com.example.studentattendencepratice.ui.theme.Claret
import com.example.studentattendencepratice.ui.theme.StudentAttendencePraticeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list2 = FileReader.readFile(this, "Attendace")
            val list3 = FileParser.PopulateLetter(list2)
            val window = rememberSize()
            //val darkTheme by remember { mutableStateOf(false) }

            StudentAttendencePraticeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = if(isSystemInDarkTheme()) Background_Color else Color.White
                ) {
                    //ImageHeader()
                    HomeScreen(list = list2, letterList = list3, windowSize = window)
                    //showingTime()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(list: ArrayList<StudentNames>, letterList: ArrayList<SortingNames>, windowSize: WindowSize){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen"){
            //SplashScreen(navController = navController)
            //SplashScreenGradient(navController = navController)
            AnimatedSlashScreen(navController = navController)
        }
        composable("home_page"){
            HeaderAndFooter(list = list, letterList = letterList, navController = navController, windowSize = windowSize)
        }

        composable("gold_star") {
            StudentGoldList(list = list, navController = navController )
        }
    }
}
