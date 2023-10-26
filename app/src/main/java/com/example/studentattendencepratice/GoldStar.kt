package com.example.studentattendencepratice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GoldStarHeader( name: String){
    Row(
        modifier = Modifier
            // wraps completely around the text
            .wrapContentSize(Alignment.TopCenter, false)
            //fills it to hit the edge of the device
            .fillMaxWidth()
            .height(80.dp)
            .background(color = colorResource(id = R.color.purple_500), shape = RectangleShape)) {

        Surface(
            shape = RectangleShape,
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .size(width = 490.dp, height = 70.dp)
                .padding(top = 20.dp, bottom = 10.dp, start = 15.dp, end = 10.dp)
        ){
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 5.dp)
            )
        }

    }

}



@Composable
fun StudentGoldList (list: ArrayList<StudentNames>, navController: NavController) {
    Button(onClick = { navController.navigate("home_page") }) {
        Text(
            textAlign = TextAlign.Center,
            text = "Gold Stars",
        )
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 80.dp)

    ) {
        val sortedNumbers = list.sortedByDescending { students ->  students.count }
        for (students:StudentNames in sortedNumbers){

            item {
                StudentGoldStars( studentNames = students)
                Divider(color = Color.Black)
            }
        }
    }
}


@Composable
fun StudentGoldStars(studentNames: StudentNames) {
    Card(modifier = Modifier
        //.padding(15.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            // change the name for the colors. They are stored in the colors.xml under resource value
            containerColor = colorResource(id = R.color.purple_200)
        ),
        shape = RectangleShape
    )
    {
        StarAwards(studentNames = studentNames)
    }
}

@Composable
fun StarAwards(studentNames: StudentNames) {
    if(studentNames.count >= 3){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Green, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                // shows the name of the category
                text = studentNames.names,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )

            Text(
                // shows the name of the category
                text = studentNames.count.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
    else if(studentNames.count > 0) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Yellow, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                // shows the name of the category
                text = studentNames.names,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )

            Text(
                // shows the name of the category
                text = studentNames.count.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
    else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                // shows the name of the category
                text = studentNames.names,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )

            Text(
                // shows the name of the category
                text = studentNames.count.toString(),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}