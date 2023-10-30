package com.example.studentattendencepratice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentattendencepratice.ui.theme.Bittersweet
import com.example.studentattendencepratice.ui.theme.Claret

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderAndFooter(list: ArrayList<StudentNames>, letterList: ArrayList<SortingNames>, navController: NavController){
    Scaffold(
        modifier = Modifier
            .padding(top = 120.dp),
        topBar =  {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(120.dp),
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
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                            )
                        }
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
                            fontSize = 25.sp,
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