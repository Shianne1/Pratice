package com.example.studentattendencepratice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.studentattendencepratice.ui.theme.Bittersweet
import kotlin.random.Random

@Composable
fun StudentDialog(studentList: ArrayList<StudentNames>) {
    val nameList = ArrayList<String>()
    var showDialog by remember { mutableStateOf(false) }
    //var clickRandom by remember { mutableStateOf(nameList) }
    Column {
        Button(onClick = { showDialog = true },
            shape =  RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Bittersweet),
            modifier = Modifier
                .padding(12.dp)
            ) {
            Text(text = "Random Student",
                fontSize = 25.sp,
                color = Color.White
                )
        }
    }
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {
            // Custom shape, background, and layout for the dialog
            Surface(
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    /*
                    val list = listOf("hello", "pie", "love", "do", "bike")
                    val randomIndex = Random.nextInt(list.size);
                    val randomElement = list[randomIndex]
                    Text("Random Student: $randomElement")

                     */

                   // val nameList = ArrayList<String>()
                    for(s in studentList){
                        nameList.add(s.names)
                    }
                    val random = Random.nextInt(nameList.size);
                    val randomStudents = nameList[random]
                    Text(text = "$randomStudents",
                        fontSize = 35.sp
                    )
                    var clickRandom by remember { mutableStateOf(randomStudents) }
                    var result = "$randomStudents"
                    Button(onClick = { result },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Click Again")
                    }

                    Button(
                        onClick = { showDialog = false },
                        shape =  RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Bittersweet),
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Close",
                            fontSize = 25.sp,
                            color = Color.White
                            )
                    }
                }
            }
        }
    }
}