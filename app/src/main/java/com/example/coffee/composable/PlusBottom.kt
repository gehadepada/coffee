package com.example.coffee.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee.R

@Composable
fun PlusBottom(
    onClick:()->Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier= Modifier
            .size(48.dp)
            .background(color= Color(0xFFF5F5F5),shape = RoundedCornerShape(100.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center

    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.addd),
            contentDescription = "add Icon",
        )
    }

}

@Composable
@Preview()
private fun ProfileIconPreview() {
    PlusBottom(onClick={})
}