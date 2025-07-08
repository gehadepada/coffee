package com.example.coffee.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.composable.CoffeeSize
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.composable.CoffeeWithSizeBox
import androidx.compose.ui.graphics.Color
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import com.example.coffee.navigation.Screen
import kotlin.math.PI
import kotlin.math.sin


@Composable
fun CoffeeDoneScreen (navController:NavController){
    val coffeeSizeStr = navController.currentBackStackEntry?.arguments?.getString("coffeeSize")
    val coffeeSize = CoffeeSize.valueOf(coffeeSizeStr ?: CoffeeSize.MEDIUM.name)
    Column(

        modifier = Modifier.fillMaxSize()
            .clip(shape = RoundedCornerShape(20.dp))
            .statusBarsPadding()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       CoffeeWithSizeBox(coffeeSize)
        Box(modifier=Modifier.padding(top=140.dp))
        {
            WavyLoadingLine(navController = navController)
        }

        Text(
            modifier = Modifier.padding(top=20.dp),
            text = "Almost Done",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Black87,
            fontFamily = UrbanistFamily
        )
        Spacer(modifier=Modifier.height(8.dp))
        Text(
            text = "Your coffee will be finish in",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Black60,
            fontFamily = UrbanistFamily
        )
        Spacer(modifier=Modifier.height(12.dp))
        Row(
            modifier =Modifier.width(187.dp)
                .height(40.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            CoffeeCharacter(R.drawable.co)
            Colon()
            CoffeeCharacter(R.drawable.ff)
            Colon()
            CoffeeCharacter(R.drawable.ee)
        }
    }

}
@Composable
private fun CoffeeCharacter(image:Int)
{
    Icon(
        modifier=Modifier.width(47.dp)
            .height(40.dp),
        painter = painterResource(id= image),
        contentDescription="co",
        tint=Coffee

    )

}
@Composable
private fun Colon()
{
    Icon(
        modifier=Modifier.width(4.dp)
            .height(12.dp),
        painter = painterResource(id= R.drawable.colon),
        contentDescription="co",

    )

}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun CoffeeDoneScreenPreview() {
    //CoffeeDoneScreen()
}


@Composable
fun WavyLoadingLine(
    navController: NavController,
    waveColor: Color = Color(0xCC000000),
    waveHeight: Float = 20f,
    waveLength: Float = 200f,
    duration: Int = 7000,
            strokeWidth: Dp = 2.dp
) {

    val progress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {

        progress.animateTo(1f, animationSpec = tween(durationMillis = duration / 2))
        progress.animateTo(0f, animationSpec = tween(durationMillis = duration / 2))

        navController.navigate(Screen.CoffeeReadyScreen.route) {
            popUpTo(Screen.CoffeeDoneScreen.route) { inclusive = true }
        }
    }

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
    ) {
        val path = Path()
        val widthPx = size.width
        val heightPx = size.height
        val points = 100
        val step = widthPx / points


        val drawLimit = widthPx * progress.value


        path.moveTo(0f, heightPx / 2)
        var x = 0f
        while (x <= drawLimit) {
            val y = heightPx / 2 +
                    sin((2 * PI * x / waveLength).toFloat()) * waveHeight
            path.lineTo(x, y)
            x += step
        }

        val strokePx = strokeWidth.toPx()

        drawPath(
            path = path,
            color = waveColor,
            style = Stroke(width = strokePx)
        )
    }
}