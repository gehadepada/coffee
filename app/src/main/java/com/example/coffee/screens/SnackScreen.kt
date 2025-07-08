package com.example.coffee.screens
import com.example.coffee.R
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.coffee.composable.CancelBottom
import com.example.coffee.navigation.Screen
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.UrbanistFamily
import kotlin.math.abs


@Composable
fun VerticalSnackPager(navController: NavController) {
    val images = listOf(
        R.drawable.cookies,
        R.drawable.croissant,
        R.drawable.pancake,
        R.drawable.chocolate,
        R.drawable.cinnamon_roll,
        R.drawable.pancake
    )

    val pagerState = rememberPagerState(initialPage = 1, pageCount = { images.size })
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    VerticalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .offset(x = -screenWidth * 0.15f),
        contentPadding = PaddingValues(vertical = screenHeight * 0.25f),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(400)
        )
    ) { index ->

        val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction

        val scale = when {
            abs(pageOffset) < 0.001f -> 1f
            pageOffset < -1f -> 0.9f.coerceAtLeast(1f - (0.1f * abs(pageOffset)))
            pageOffset < 0f -> 1f - (0.1f * abs(pageOffset))
            else -> 1f - (0.2f * abs(pageOffset))
        }

        val rotation = when {
            abs(pageOffset) < 0.1f -> 2f
            pageOffset < -1f -> lerp(
                -4f * -1f,
                -4f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> -8f * pageOffset
            else -> -8f * pageOffset
        }

        val offsetX = when {
            pageOffset < -1f -> lerp(
                screenWidth.value * 0.4f * -1f,
                screenWidth.value * 0.8f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> screenWidth.value * 0.4f * pageOffset
            else -> -screenWidth.value * 0.5f * pageOffset
        }

        val offsetY = when {
            pageOffset < -1f -> lerp(
                screenHeight.value * 0.06f * -1f,
                screenHeight.value * 0.5f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> screenHeight.value * 0.10f * pageOffset
            else -> screenHeight.value * 0.5f * pageOffset
        }


        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale * 1.1f
                    scaleY = scale * 1.1f
                    rotationZ = rotation
                    translationX = offsetX
                    translationY = offsetY
                }
                .size(width = 260.dp, height = 274.dp)
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(32.dp)
                )
                .clickable(
                    onClick = { navController.navigate(Screen.SnakeDetailsScreen.withImageRes(images[index])) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(images[index]),
                contentDescription = "Snack ${index + 1}",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(width = 144.dp, height = 149.dp) // fixed image size
            )
        }
    }
}



@Composable
fun SnackScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            CancelBottom ({ navController.navigate(Screen.HomeScreen.route) })
        }


        Text(
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, bottom = 8.dp),
            text = "Take your snack",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Black87,
            fontFamily = UrbanistFamily
        )

        VerticalSnackPager(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun SnackScreenPreview() {
   // SnackScreen()
}