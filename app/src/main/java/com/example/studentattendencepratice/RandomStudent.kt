package com.example.studentattendencepratice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlin.random.Random

@Composable
fun StudentDialog(studentList: ArrayList<StudentNames>) {
    var showDialog by remember { mutableStateOf(false) }
    Column {
        Button(onClick = { showDialog = true }) {
            Text(text = "Random Student" )
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

                    val nameList = ArrayList<String>()
                    for(s in studentList){
                        nameList.add(s.names)
                    }
                    val random = Random.nextInt(nameList.size);
                    val randomStudents = nameList[random]
                    Text(text = "$randomStudents",
                        fontSize = 35.sp
                    )

                    Button(
                        onClick = { showDialog = false },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Close")
                    }
                }
            }
        }
    }
}