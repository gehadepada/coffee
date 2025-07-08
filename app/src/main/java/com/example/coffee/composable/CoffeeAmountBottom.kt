package com.example.coffee.composable


import android.graphics.BlurMaskFilter
import android.graphics.Paint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.ui.theme.Black60
import com.example.coffee.ui.theme.Coffee

@Composable
fun CoffeeAmountBottom(
    selectedIndex: Int,
    onSelect: (Int) -> Unit,

) {


    val offsetX = when (selectedIndex) {
        0 -> 0.dp
        1 -> 51.dp
        else -> 99.dp
    }

    Box(
        modifier = Modifier
            .width(152.dp)
            .height(56.dp)
            .background(color = Color(0xFFF5F5F5), shape = RoundedCornerShape(100.dp))
            .padding(8.dp)
            .clickable {

            }
    ) {


            Box(
                modifier = Modifier
                    .offset(x = offsetX)
                    .size(40.dp)
                    .background(Coffee, shape = RoundedCornerShape(100.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .offset(y = 6.dp)
                        .drawBehind {
                            val paint = Paint().apply {
                                color = Color(0xFFB94B23).copy(alpha = 0.5f).toArgb()
                                maskFilter = BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL)
                            }

                            drawIntoCanvas {
                                it.nativeCanvas.drawRoundRect(
                                    0f,
                                    0f,
                                    size.width,
                                    size.height,
                                    size.width,
                                    size.height,
                                    paint
                                )
                            }
                        }

                )
                Icon(
                    painter = painterResource(id = R.drawable.coffee_beans),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()

            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onSelect(index) }
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center,

                    ) {

                    }
                }
            }
        }
    }

