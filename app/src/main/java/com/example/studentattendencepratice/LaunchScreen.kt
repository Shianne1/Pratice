package com.example.studentattendencepratice

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.view.animation.OvershootInterpolator
import android.window.SplashScreenView
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentattendencepratice.ui.theme.Bittersweet
import kotlinx.coroutines.delay


@Composable
fun AnimatedSlashScreen(navController: NavController){
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    var startAnimation by remember { mutableStateOf(false) }
    /*
    val anim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000),
    )

     */

    val animWord = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 4000),
        label = "Animating Logo",
    )

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate("home_page")
    }
    Box( modifier = Modifier
        .background(if (isSystemInDarkTheme()) Color.Black else Bittersweet)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column() {
            Image(
                painter = painterResource(id = R.drawable.good_job),
                contentDescription = "null",
                modifier = Modifier
                    .size(200.dp)
                    .scale(scale.value)

            )

            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "Student Attendance",
                modifier = Modifier
                    .alpha(animWord.value)
            )
        }
    }
    //Splash(/*alpha = anim.value,*/ alpha1 = animWord.value, scale = scale.value)
}

@Composable
fun Splash(alpha: Float, alpha1: Float, scale: Float){
    Box( modifier = Modifier
        .background(if (isSystemInDarkTheme()) Color.Black else Bittersweet)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Image(
                painter = painterResource(id = R.drawable.good_job),
                contentDescription = "null",
                modifier = Modifier
                    .size(200.dp)
                    .alpha(alpha = alpha)
                    .scale(scale = scale)
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "Student Attendance",
                modifier = Modifier
                    .alpha(alpha = alpha1)
                )
        }
    }
}

/*
@Composable
@Preview
fun SplashScreenView(){
    Splash(alpha = 1f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenDarkMode(){
    Splash(alpha = 1f)
}

 */


@Composable
fun SplashScreen(navController: NavController, onTimeout: () -> Unit) {
    /*
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

     */

    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    val updateOnTimeOut by rememberUpdatedState(newValue = onTimeout)

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        delay(6000L)
        updateOnTimeOut()
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
        Column {
        Text(text = "Hello", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(100.dp))
            /*
        for (i in 1..100) {
            Text(text = "$i")

        }

             */
            val values = 0 + (100 - 0) * 100
            Text(text = "$values")
    }
    }
    LaunchedEffect(Unit) {

        delay(3000)

        navController.navigate("home_page")
    }
}

@Composable
fun showingTime(){
    LaunchedEffect(Unit) {
        for (i in 1..100){
            delay(1000)
            print("$i")
        }
    }
}