package com.example.coffee.ui.theme.screens

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black70
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.composable.ContinueBottom
import com.example.coffee.ui.theme.composable.PlusBottom
import com.example.coffee.ui.theme.composable.TakeSnackBottom

@Composable
fun CoffeeReadyScreen() {

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 16.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(20.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            contentAlignment = Alignment.TopStart


        ) {
            PlusBottom()
        }
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(56.dp)
                .background(
                    color = Coffee,
                    shape = RoundedCornerShape(100.dp)
                )
                .clickable {

                }
                .padding(vertical = 8.dp, horizontal = 10.dp),
            contentAlignment = Alignment.Center
        )
        {
            Icon(
                modifier = Modifier
                    .size(32.dp),
                painter = painterResource(id = R.drawable.tick),
                contentDescription = "star Icon",
                tint = Color.White
            )

        }

        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Your coffee is ready,\n" +
                    "\t\t\t\t\t\t\t\t\t\tEnjoy",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Black87,
            fontFamily = UrbanistFamily
        )
        Image(
            modifier = Modifier
                .padding(top = 39.dp)
                .width(245.dp)
                .height(300.dp),
            painter = painterResource(R.drawable.empty_cup),
            contentDescription = "cup of coffe"
        )
        Row(
            modifier = Modifier.padding(top = 47.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            Box()
            {

            }
            Text(
                text = "Take Away",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Black70,
                fontFamily = UrbanistFamily
            )


        }
        Spacer(modifier=Modifier.height(16.dp))
        TakeSnackBottom()


    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun CoffeeReadyScreenPreview() {
    CoffeeReadyScreen()
}