package com.example.coffee.composable


import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.White87

@Composable
fun ThankYouBottom(
    onClick:()->Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .width(192.dp)
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
            onClick()
            }
            .padding(horizontal = 32.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Thank You",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = White87,
                fontFamily = UrbanistFamily
            )
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(R.drawable.arrow_right_04),
                contentDescription = "arrow"
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ThankYouBottomPreview() {
    //ThankYouBottom()
}