package com.example.coffee.composable
import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import android.graphics.Paint
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.ui.theme.White87

@Composable
fun CoffeeSizeBottom(
    selectedSize:CoffeeSize,
    onSizeSelected:(CoffeeSize)->Unit
)
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
            CoffeeSize.values().forEach { size ->
                SmallSizeBottom(
                    text = size.label,
                    isSelected = selectedSize == size,
                    onClick = { onSizeSelected(size) }
                )
            }
        }
    }
}
@Composable
private fun SmallSizeBottom(
    text:String,
    isSelected:Boolean,
    onClick:()->Unit
) {
    val background = if (isSelected) Coffee else Color(0xFFF5F5F5)
    val textColor = if (isSelected) White87 else Black60
    val shadowColor = if (isSelected) Color(0xFFB94B23).copy(alpha = 0.4f) else Color.Transparent
    Box(modifier = Modifier.size(width = 40.dp, height = 40.dp)) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .offset(y = 6.dp)
                .drawBehind {
                    val paint = Paint().apply {
                        color = shadowColor.toArgb()
                        maskFilter = BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)
                    }

                    drawIntoCanvas {
                        it.nativeCanvas.drawRoundRect(
                            0f,
                            0f,
                            size.width,
                            size.height,
                            size.width ,
                            size.height ,
                            paint
                        )
                    }
                }

        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = background,
                    shape = RoundedCornerShape(100.dp)
                )

                .clickable {
                    onClick()

                }
                .padding(vertical = 8.dp, horizontal = 10.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                fontFamily = UrbanistFamily
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CoffeeSizeBottomPreview() {
 //  CoffeeSizeBottom()
}