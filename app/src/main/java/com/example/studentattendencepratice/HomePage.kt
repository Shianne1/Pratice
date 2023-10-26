package com.example.studentattendencepratice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Header( name: String){
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



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StudentList (list: ArrayList<StudentNames>,sort: ArrayList<SortingNames>, paddingValues: PaddingValues) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            //.padding(top = 80.dp)
            .padding(paddingValues)
    ) {
        val sortLetters = sort.sortedBy { sortingNames -> sortingNames.letter }
        for(sortingNames: SortingNames in sortLetters){
            stickyHeader { LetterCard(sortingNames = sortingNames) }
            val sortStudents = list.sortedBy { students -> students.names }
            for (students:StudentNames in sortStudents){
                if(students.names.first().toString().equals(sortingNames.letter, true)){
                    item {
                        StudentCard(studentNames = students)
                        Divider(color = Color.Black)
                    }
                }
                /*
                if(students.names.first().toString().equals(sortingNames.letter, true)){
                    item {
                        StudentCard(studentNames = students)
                        Divider(color = Color.Black)
                    }
                }

                 */
            }
        }

/*
        for (students:StudentNames in list){
            item { StudentCard( studentNames = students)
            Divider(color = Color.Black)}
        }

 */

    }
}

@Composable
fun LetterCard(sortingNames: SortingNames) {
    Card(modifier = Modifier
        //.padding(15.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            // change the name for the colors. They are stored in the colors.xml under resource value
            containerColor = colorResource(id = R.color.purple_500)
        ),
        shape = RectangleShape
    )
    {
        Text(
            // shows the name of the category
            text = sortingNames.letter.uppercase(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun StudentCard(studentNames: StudentNames) {
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
        Text(
            // shows the name of the category
            text = studentNames.names,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

    }
}