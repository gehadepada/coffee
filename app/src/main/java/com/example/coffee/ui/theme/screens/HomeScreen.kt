package com.example.coffee.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.composable.PlusBottom
import com.example.coffee.ui.theme.composable.ProfileIcon

@Composable
fun HomeScreen () {
    Column(
        modifier = Modifier.fillMaxSize(),

    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 67.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileIcon()
            PlusBottom()
        }
        Row(modifier = Modifier.fillMaxWidth().padding(top=24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hocus\n" +
                        "Pocus\n" +
                        "I Need Coffee\n" +
                        "to Focus",
                fontSize=32.sp,
                fontWeight = FontWeight(400),
                color=Black87


            )
        }

    }
}
@Composable
@Preview(showBackground = true , showSystemUi = true)
private fun HomeScreenPreview()
{
    HomeScreen()

}
