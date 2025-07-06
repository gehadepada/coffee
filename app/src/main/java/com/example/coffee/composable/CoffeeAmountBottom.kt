package com.example.coffee.composable


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun CoffeeAmountBottom()
{
    Box(
        modifier = Modifier
            .width(152.dp)
            .height(56.dp)
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(100.dp)
            )
            .clickable {

            }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SmallSizeBottom()
            SmallSizeBottom()
            SmallSizeBottom()


        }
    }

}
@Composable
private fun SmallSizeBottom()
{
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = Coffee,
                shape = RoundedCornerShape(100.dp)
            )
            .clickable {

            }
            .padding(vertical = 8.dp , horizontal = 10.dp),
        contentAlignment = Alignment.Center
    )
    {
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = R.drawable.coffee_beans),
            contentDescription = "star Icon",
            tint=Color.White
        )

    }
}
@Composable
@Preview(showBackground = true)
private fun CoffeeAmountBottomPreview() {
    CoffeeAmountBottom()
}