package com.example.studentattendencepratice

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentattendencepratice.ui.theme.Bittersweet
import com.example.studentattendencepratice.ui.theme.Claret

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderAndFooter(list: ArrayList<StudentNames>, letterList: ArrayList<SortingNames>, navController: NavController, windowSize: WindowSize){
    val modifierHeight by remember(key1 = windowSize) {
        mutableStateOf(if(windowSize.width == WindowType.Compact) 90 else 120)
    }

    val textFont by remember(key1 = windowSize) {
        mutableStateOf(if(windowSize.width == WindowType.Compact)25 else 40)
    }

    val buttonFont by remember(key1 = windowSize) {
        mutableStateOf(if(windowSize.width == WindowType.Compact)15 else 25)
    }

    val context = LocalContext.current
    val webIntent: Intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://www.geeksforgeeks.org/how-to-open-an-external-url-on-button-click-in-android-using-jetpack-compose/?ref=ml_lbp") )
    Scaffold(
        /*
        modifier = Modifier
            .padding(top = 120.dp),

         */
        topBar =  {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(modifierHeight.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Claret,
                ),
                title = {
                    Row(
                        modifier = Modifier
                            .padding(top = 25.dp, bottom = 10.dp)
                    ) {
                        TextButton( onClick = { /*TODO*/ }) {
                            Text(
                                text = "STUDENT'S ATTENDANCE",
                                fontSize = textFont.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = {
                        context.startActivity(webIntent)
                    }){
                        Icon(imageVector = Icons.Filled.Info,
                            contentDescription = "Info Icon",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .size(40.dp)
                            )
                    }
                }
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = Claret,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .height(90.dp),
            )
            {
                Row( modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){

                    TotalDialog(studentList = list)

                    Button(onClick = { navController.navigate("gold_star") },
                        shape =  RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Bittersweet),
                        modifier = Modifier
                            .padding(12.dp)

                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Gold Stars",
                            fontSize = buttonFont.sp,
                            color = Color.White
                        )
                    }

                    StudentDialog(studentList = list)
                }
            }
        },
    ) { innerPadding ->
        StudentList(list = list, sort =  letterList, paddingValues = innerPadding)
    }
}