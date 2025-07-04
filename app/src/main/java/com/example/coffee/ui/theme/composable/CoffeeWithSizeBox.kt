package com.example.coffee.ui.theme.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.UrbanistFamily

@Composable
fun CoffeeWithSizeBox()
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(341.dp)

    )
    {
        Text(
            modifier = Modifier.offset(x = 16.dp, y = 64.dp),
            text = "200 ML",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Black60,
            fontFamily = UrbanistFamily
        )
        Box(
            modifier = Modifier
                .padding(start = 32.dp, top = 49.dp)
                .width(199.4.dp)
                .height(244.dp)

        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.empty_cup),
                contentDescription = "shadow image",
                contentScale = ContentScale.Crop

            )
        }
    }
}
@Composable
@Preview(showBackground = true)
private fun CoffeeWithSizeBoxPreview() {
    CoffeeWithSizeBox()
}