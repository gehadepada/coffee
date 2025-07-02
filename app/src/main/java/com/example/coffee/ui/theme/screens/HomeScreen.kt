package com.example.coffee.ui.theme.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.ModifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.SnigletFamily
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.White87
import com.example.coffee.ui.theme.composable.PlusBottom
import com.example.coffee.ui.theme.composable.ProfileIcon

@Composable
fun HomeScreen() {
    val infiniteTransition = rememberInfiniteTransition()


    val star1Alpha by infiniteTransition.animateFloat(
        initialValue = 0.1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        ),
    )

    val star1Scale by infiniteTransition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(700),
            repeatMode = RepeatMode.Reverse
        ),

    )


    val star2Alpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        ),
    )

    val star2Scale by infiniteTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(700),
            repeatMode = RepeatMode.Reverse
        ),

    )


    val star3Alpha by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(300),
            repeatMode = RepeatMode.Reverse
        ),

    )

    val star3Scale by infiniteTransition.animateFloat(
        initialValue = 0.7f,
        targetValue = 1.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(400),
            repeatMode = RepeatMode.Reverse
        ),
        label = "star3Scale"
    )

    Column(
        modifier = Modifier.fillMaxSize().clip(shape= RoundedCornerShape(20.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
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
            PlusBottom()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hocus",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = Black87,
                fontFamily = SnigletFamily
            )
            // First animated star
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .offset(x = 30.dp)
                    .alpha(star1Alpha)
                    .scale(star1Scale),
                painter = painterResource(id = R.drawable.star),
                contentDescription = "star Icon",
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 21.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // Second animated star
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .offset(x = (-38).dp, y = 10.dp)
                    .alpha(star2Alpha)
                    .scale(star2Scale),
                painter = painterResource(id = R.drawable.star),
                contentDescription = "star Icon",
            )
            Text(
                modifier = Modifier.offset(x = (-15).dp),
                text = "Pocus",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = Black87,
                fontFamily = SnigletFamily
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 21.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "I Need Coffee",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = Black87,
                fontFamily = SnigletFamily
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 21.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "to Focus",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                color = Black87,
                fontFamily = SnigletFamily
            )
            // Third animated star
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .offset(x = 40.dp, y = 30.dp)
                    .alpha(star3Alpha)
                    .scale(star3Scale),
                painter = painterResource(id = R.drawable.star),
                contentDescription = "star Icon",
            )
        }
        Spacer(modifier=Modifier.height(33.dp))

        Image(
            modifier = Modifier
                .size(244.dp),
            painter = painterResource(R.drawable.gost),
            contentDescription = "gost image",
        )
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(27.65.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.shadow),
                contentDescription = "shadow image",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(58.91.dp))
        Box(
            modifier = Modifier
                .width(215.dp)
                .height(56.dp)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(100.dp),
                    ambientColor = Color.Black.copy(alpha = 0.24f),
                    spotColor = Color.Black.copy(alpha = 0.24f)
                )
                .background(
                    color = Color(0xFF1F1F1F),
                    shape = RoundedCornerShape(100.dp)
                )
                .clickable {

                },
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "bring my coffee",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = White87,
                    fontFamily = UrbanistFamily
                )
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(R.drawable.cup),
                    contentDescription = "cup of coffe"
                )
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun HomeScreenPreview() {
    HomeScreen()
}