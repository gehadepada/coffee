package com.example.coffee.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black100
import com.example.coffee.ui.theme.Black80
import com.example.coffee.ui.theme.Gray100
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.White87
import com.example.coffee.composable.ContinueBottom
import com.example.coffee.composable.PlusBottom
import com.example.coffee.composable.ProfileIcon

@Composable
fun CoffeeScreen() {
    Column(
        modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(20.dp)),
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
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Good Morning",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Gray100,
                fontFamily = UrbanistFamily
            )
            Text(
                text = "Gehad ☀",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Black100,
                fontFamily = UrbanistFamily
            )
            Text(
                text = "What would you like to drink today?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Black80,
                fontFamily = UrbanistFamily
            )
            Image(
                modifier = Modifier.width(193.47.dp)
                    .height(244.dp),
                painter = painterResource(R.drawable.empty_cup),
                contentDescription = "cup of coffe"
            )
            Text(
                text = "black",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Black80,
                fontFamily = UrbanistFamily
            )
            ContinueBottom()

        }

    }
}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun CoffeeScreenPreview() {
    CoffeeScreen()
}