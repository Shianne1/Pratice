package com.example.studentattendencepratice

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }


    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))

        // Customize the delay time
        delay(6000L)
        navController.navigate("home_page")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.banner1),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}

@Composable
fun SplashScreenGradient(navController: NavController) {
    val gradiantBackground = Brush.horizontalGradient(
        0.0f to Color(red = 237, green = 118, blue = 94),
        1.0f to Color(red = 254, green = 168, blue = 88),
        startX = 0.0f,
        endX = 1000.0f
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradiantBackground),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
    LaunchedEffect(Unit) {
        for (i in 1..100){
            delay(3000)
            print("$i")
        }
        //delay(3000)
        navController.navigate("home_page")
    }
}