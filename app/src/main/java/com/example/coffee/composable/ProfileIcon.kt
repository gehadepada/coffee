package com.example.coffee.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffee.R

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier

) {

    Image(
        modifier = modifier.size(48.dp),
        painter = painterResource(id = R.drawable.pfp),
        contentDescription = "Profile Icon",
    )


}

@Composable
@Preview()
private fun ProfileIconPreview() {
    ProfileIcon()
}