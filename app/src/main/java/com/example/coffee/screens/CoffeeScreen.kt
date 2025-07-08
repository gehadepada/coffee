package com.example.coffee.screens

import androidx.compose.foundation.Image
import androidx.compose.ui.util.lerp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.ui.theme.Black100
import com.example.coffee.ui.theme.Black80
import com.example.coffee.ui.theme.Gray100
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.White87
import com.example.coffee.composable.ContinueBottom
import com.example.coffee.composable.PlusBottom
import com.example.coffee.composable.ProfileIcon
import com.example.coffee.navigation.Screen
import kotlin.math.absoluteValue

@Composable
fun CoffeeScreen(
    navController: NavController
) {
    CoffeeScreenContent(onClickNext={navController.navigate(Screen.CoffeeDetailsScreen.route)},
        onClickPlus={navController.navigate(Screen.CoffeeScreen.route)})
}
@Composable
private fun CoffeeScreenContent(
    onClickNext:()->Unit,
    onClickPlus:()->Unit
){
    val CoffeeData= listOf(
        CoffeeWithName(R.drawable.espresso),
        CoffeeWithName(R.drawable.macchiato),
        CoffeeWithName(R.drawable.latte),
        CoffeeWithName(R.drawable.black),

    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { CoffeeData.size }
    )
    Column(
        modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(20.dp)),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileIcon()
            PlusBottom(onClickPlus)
        }
        Column(
            modifier=Modifier.padding(start=16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(

                text = "Good Morning",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Gray100,
                fontFamily = UrbanistFamily
            )
            Text(
                text = "Hamsa ☀",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Black100,
                fontFamily = UrbanistFamily
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "What would you like to drink today?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Black80,
                fontFamily = UrbanistFamily
            )
        }

       Spacer(modifier=Modifier.height(56.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 95.dp),
            pageSpacing = 16.dp
        ) { page ->
            val coffee = CoffeeData[page]
            val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
            val yOffset = androidx.compose.ui.unit.lerp(
                start = 30.dp,
                stop = 0.dp,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
            )
            val scale = lerp(
                start = 0.8f,
                stop = 1.0f,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
            )

            CoffeeItem(
                coffee = coffee,
                scale = scale,
                modifier = Modifier.offset(y = yOffset)

            )
        }


        Box(
            modifier=Modifier.fillMaxWidth().padding(top=111.dp,start=99.dp)

        )
        {

            ContinueBottom(onClickNext)
        }



    }
}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun CoffeeScreenContentPreview() {
    CoffeeScreenContent(onClickNext = {}, onClickPlus = {})
}
@Composable
private fun CoffeeItem(
    coffee: CoffeeWithName,
    scale: Float = 1f,
    alpha: Float = 1f,
    modifier: Modifier= Modifier
) {
    Box(
        modifier = modifier
            .width(240.dp)
            .height(300.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                this.alpha = alpha
            },
                contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            painter = painterResource(id = coffee.imageRes),
            contentDescription = "cup of ",
            //contentScale = ContentScale.Fit
        )

    }
}
