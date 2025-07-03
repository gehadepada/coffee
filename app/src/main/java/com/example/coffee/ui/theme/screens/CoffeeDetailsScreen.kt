package com.example.coffee.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.composable.BackBottom
import com.example.coffee.ui.theme.composable.CoffeeAmountBottom
import com.example.coffee.ui.theme.composable.CoffeeSizeBottom
import com.example.coffee.ui.theme.composable.ContinueBottom

@Composable
fun CoffeeDetailsScreen() {
    Column(
        modifier = Modifier.background(Color.White),
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
            BackBottom()
            Text(
                modifier = Modifier.padding(top = 9.5.dp),
                text = "Macchiato",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Black87,
                fontFamily = UrbanistFamily
            )
        }
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
        CoffeeSizeBottom()
        Spacer(modifier = Modifier.height(16.dp))
        CoffeeAmountBottom()
        Row(
            modifier = Modifier
                .width(152.dp)
                .height(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            TextSize()
            TextSize()
            TextSize()

        }
        Spacer(modifier = Modifier.height(92.dp))
        ContinueBottom()


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
private fun CoffeeDetailsScreenPreview() {
    CoffeeDetailsScreen()
}