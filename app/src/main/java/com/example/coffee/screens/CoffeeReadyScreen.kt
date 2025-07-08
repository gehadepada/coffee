package com.example.coffee.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.composable.CancelBottom
import com.example.coffee.ui.theme.Black70
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.composable.ContinueBottom
import com.example.coffee.composable.CustomSwitch
import com.example.coffee.composable.PlusBottom
import com.example.coffee.composable.TakeSnackBottom
import com.example.coffee.navigation.Screen

@Composable
fun CoffeeReadyScreen(navController: NavController) {
    var isCoffeeOn by remember { mutableStateOf(false) }
    var startAnimation by remember { mutableStateOf(false) }


    val coverOffset by animateDpAsState(
        targetValue = if (startAnimation) 260.dp else (-400).dp,
        animationSpec = tween(durationMillis = 1000, delayMillis = 400),
        label = "coverOffset"
    )


    val topComponentsOffset by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else (-200).dp,
        animationSpec = tween(durationMillis = 800, delayMillis = 0),
        label = "topComponentsOffset"
    )


    val bottomButtonOffset by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else (200).dp,
        animationSpec = tween(durationMillis = 800, delayMillis = 300),
        label = "bottomButtonOffset"
    )


    val cupAlpha by animateDpAsState(
        targetValue = if (startAnimation) 1.dp else 0.dp,
        animationSpec = tween(durationMillis = 800, delayMillis = 400),
        label = "cupAlpha"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 16.dp)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .offset(y = topComponentsOffset)
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                contentAlignment = Alignment.TopStart
            ) {
                CancelBottom({navController.navigate(Screen.HomeScreen.route)})
            }

            Box(
                modifier = Modifier
                    .offset(y = topComponentsOffset)
                    .padding(top = 16.dp)
                    .size(56.dp)
                    .background(color = Coffee, shape = RoundedCornerShape(100.dp))
                    .clickable { }
                    .padding(vertical = 8.dp, horizontal = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.tick),
                    contentDescription = "star Icon",
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .offset(y = topComponentsOffset)
                    .padding(top = 24.dp),
                text = "Your coffee is ready,\nEnjoy",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Black87,
                fontFamily = UrbanistFamily
            )


            Image(
                modifier = Modifier
                    .padding(top = 39.dp)
                    .width(245.dp)
                    .height(300.dp)
                    .alpha(cupAlpha.value),
                painter = painterResource(R.drawable.empty_cup),
                contentDescription = "cup of coffee"
            )

            Row(
                modifier = Modifier
                    .offset(y = topComponentsOffset)
                    .padding(top = 47.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CustomSwitch(
                    isChecked = isCoffeeOn,
                    onCheckedChange = { isCoffeeOn = it },
                    offText = "OFF",
                    onText = "ON",
                    iconRes = R.drawable.ic_coffee
                )

                Text(
                    modifier = Modifier.offset(y = 10.dp),
                    text = "Take Away",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black70,
                    fontFamily = UrbanistFamily
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Box(modifier = Modifier.offset(y = bottomButtonOffset)) {
                TakeSnackBottom({navController.navigate(Screen.SnakeScreen.route)})
            }
        }


        Image(
            modifier = Modifier
                .absoluteOffset(y = coverOffset)
                .align(Alignment.TopCenter)
                .width(260.dp)
                .height(72.dp),
            painter = painterResource(R.drawable.cover),
            contentDescription = "dropping coffee"
        )
    }
}
