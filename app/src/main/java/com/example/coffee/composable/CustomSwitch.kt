package com.example.coffee.composable

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily

@Composable
fun CustomSwitch(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    offText: String = "OFF",
    onText: String = "ON",
    iconRes: Int = R.drawable.ic_coffee
) {

    val thumbOffset by animateFloatAsState(
        targetValue = if (isChecked) 0f else 41f,
        animationSpec = tween(durationMillis = 300)
    )


    val backgroundColor by animateColorAsState(
        targetValue = if (isChecked) Coffee else Color(0xFFFFEEE7),
        animationSpec = tween(durationMillis = 300)
    )


    val textColor by animateColorAsState(
        targetValue = if (isChecked) Color(0x99FFFFFF) else Black60,
        animationSpec = tween(durationMillis = 300)
    )

    val thumbColor by animateColorAsState(
        targetValue = if (isChecked) Color.White else Coffee,
        animationSpec = tween(durationMillis = 300)
    )

    Box(
        modifier = modifier
            .width(78.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable { onCheckedChange(!isChecked) }
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = offText,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,//if (!isChecked) Color.White else textColor.copy(alpha = 0.7f),
                fontFamily = UrbanistFamily
            )
            Text(
                text = onText,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color =textColor,// if (!isChecked) Color.White.copy(alpha = 0.7f) else textColor,
                fontFamily = UrbanistFamily
            )
        }


        Box(
            modifier = Modifier
                .size(40.dp)
                .offset(x = thumbOffset.dp)
                .padding(2.dp)
                .clip(CircleShape)
                .background(thumbColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .graphicsLayer {

                        scaleX = if (isChecked) -1f else 1f
                    }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomSwitchPreview() {
    var isChecked by remember { mutableStateOf(false) }
    CustomSwitch(
        isChecked = isChecked,
        onCheckedChange = { isChecked = it },
        modifier = Modifier.padding(16.dp)
    )
}
