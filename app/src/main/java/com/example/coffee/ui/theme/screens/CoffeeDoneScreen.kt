package com.example.coffee.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.composable.CoffeeWithSizeBox

@Composable
fun CoffeeDoneScreen (){
    Column(
        modifier = Modifier.fillMaxSize()
            .clip(shape = RoundedCornerShape(20.dp))
            .statusBarsPadding()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoffeeWithSizeBox()

        Text(
            modifier = Modifier.padding(top=170.dp),
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
            CoffeeCharacter()
            Colon()
            CoffeeCharacter()
            Colon()
            CoffeeCharacter()
        }
    }

}
@Composable
private fun CoffeeCharacter()
{
    Icon(
        modifier=Modifier.width(47.dp)
            .height(40.dp),
        painter = painterResource(id= R.drawable.co),
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
    CoffeeDoneScreen()
}