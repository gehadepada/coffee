package com.example.coffee.screens
import com.example.coffee.R
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.coffee.composable.CancelBottom
import com.example.coffee.composable.PlusBottom
import com.example.coffee.navigation.Screen
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.UrbanistFamily
import kotlin.math.abs

@Composable
fun CardSnack(
    imageRes: Int,
    contentDescription: String,
    scale: Float,
    rotationZ: Float,
    offsetY: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .offset(y = offsetY)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                rotationZ = rotationZ,
            )
    ) {
        Box(
            modifier = Modifier
                .width(195.31.dp)
                .height(205.5.dp)
                .clip(
                    androidx.compose.foundation.shape.RoundedCornerShape(
                        topEnd = 32.dp,
                        bottomEnd = 32.dp
                    )
                )
                .background(Color(0xFFF5F5F5))
                .shadow(
                    elevation = 3.dp,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(
                        topEnd = 32.dp,
                        bottomEnd = 32.dp
                    ),
                    ambientColor = Color(0x1F000000),
                    spotColor = Color(0x1F000000)
                )
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotationZ,
                    alpha = 1f
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 1500,
                        easing = FastOutSlowInEasing
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(144.23.dp * scale)
                    .height(149.dp * scale)
            )
        }
    }
}

@Composable
fun VerticalSnackPager(navController: NavController) {
    val images = listOf(
        R.drawable.cookies,
        R.drawable.croissant,
        R.drawable.pancake,
        R.drawable.chocolate

    )
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { images.size })
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = 260.38.dp
    val itemHeight = 274.dp
    val contentPadding = (screenWidth - itemWidth) / 2

    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(itemWidth),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            horizontal = contentPadding,
            vertical = 100.dp
        ),
        modifier = Modifier
            .height(450.dp)
            .zIndex(1f)
    ) { index ->
        val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
        val absOffset = abs(pageOffset)

        val scale = 1f - (absOffset * 1f).coerceAtMost(0.1f)
        val rotationZ = pageOffset * -4f
        val offsetY = (pageOffset * 80.dp).coerceIn((-120).dp, 120.dp)

        CardSnack(
            imageRes = images[index],
            contentDescription = "snack $index",
            scale = scale,
            rotationZ = rotationZ,
            offsetY = offsetY,
            modifier = Modifier
                .clickable {

                    navController.navigate(Screen.SnakeDetailsScreen.withImageRes(images[index]))
                }
        )
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