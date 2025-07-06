package com.example.coffee.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.composable.PlusBottom

@Composable
fun SnackScreen() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 16.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(20.dp)),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            contentAlignment = Alignment.TopStart


        ) {
            PlusBottom()
        }
        Text(
            modifier = Modifier.padding(top=24.dp,start=16.dp),
            text = "Take your snack",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Black87,
            fontFamily = UrbanistFamily
        )
        Box(
            modifier = Modifier
                .width(260.41.dp)
                .height(274.dp)
                .background(color= Color(0xFFF5F5F5) ,shape= RoundedCornerShape(32.dp) )
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 39.dp)
                    .width(245.dp)
                    .height(300.dp),
                painter = painterResource(R.drawable.cookies),
                contentDescription = "cup of coffe"
            )
        }

    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=360dp,height=800dp,dpi=420"
)
private fun SnackScreenPreview() {
    SnackScreen()
}