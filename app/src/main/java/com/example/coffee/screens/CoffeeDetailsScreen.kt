package com.example.coffee.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.composable.BackBottom
import com.example.coffee.composable.CoffeeAmountBottom
import com.example.coffee.composable.CoffeeSize
import com.example.coffee.composable.CoffeeSizeBottom
import com.example.coffee.composable.CoffeeWithSizeBox
import com.example.coffee.composable.ContinueBottom
import com.example.coffee.navigation.Screen
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.UrbanistFamily

@Composable
fun CoffeeDetailsScreen(
    navController: NavController
) {
    var selectedSize by remember { mutableStateOf(CoffeeSize.MEDIUM) }
    val onClickNext={navController.navigate(Screen.CoffeeDoneScreen.withSize(selectedSize))}
    //val onClickBack:()->Unit
    var selectedAmount by remember{ mutableStateOf(0) }
    var isDropping by remember { mutableStateOf(false) }

    val dropY by animateDpAsState(
        targetValue = if (isDropping) 80.dp else -150.dp,
        animationSpec = tween(durationMillis = 1000),
        finishedListener = {
            isDropping = false
        }
    )


    val dropAlpha by animateFloatAsState(
        targetValue = if (isDropping)0.3f else 1.0f,
        animationSpec = tween(durationMillis = 1000)
    )


    val dropSize by animateDpAsState(
        targetValue = if (isDropping) 120.dp else 160.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 16.dp)
                    .padding(start = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                BackBottom({navController.navigateUp()})
                Text(
                    modifier = Modifier.padding(top = 9.5.dp),
                    text = "Macchiato",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black87,
                    fontFamily = UrbanistFamily
                )
            }

            CoffeeWithSizeBox(selectedSize = selectedSize)

            CoffeeSizeBottom(
                selectedSize = selectedSize,
                onSizeSelected = { selectedSize = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CoffeeAmountBottom(
                selectedAmount,
                onSelect = {
                    selectedAmount = it
                    isDropping = true
                }
            )

            Row(
                modifier = Modifier
                    .width(152.dp)
                    .height(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextSize()
                TextSize()
                TextSize()
            }

            Spacer(modifier = Modifier.height(92.dp))
            ContinueBottom(onClickNext)
        }

        if (isDropping) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = dropY)
                    .size(dropSize)
                    .alpha(dropAlpha)
            ) {
                Image(
                    modifier = Modifier.size(dropSize),
                    painter = painterResource(R.drawable.coffe),
                    contentDescription = "dropping coffee"
                )
            }
        }
    }
}

@Composable
private fun TextSize() {
    Text(
        modifier = Modifier,
        text = "Low",
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        color = Black60,
        fontFamily = UrbanistFamily
    )
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun CoffeeDetailsScreenContentPreview() {
   // CoffeeDetailsScreenContent(onClickNext={}, onClickBack = {})
}