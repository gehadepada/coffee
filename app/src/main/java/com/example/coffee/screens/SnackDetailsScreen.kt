package com.example.coffee.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.navigation.NavController
import com.example.coffee.R
import com.example.coffee.composable.CancelBottom
import com.example.coffee.ui.theme.Black87
import com.example.coffee.ui.theme.Coffee
import com.example.coffee.ui.theme.UrbanistFamily
import com.example.coffee.composable.PlusBottom
import com.example.coffee.composable.ThankYouBottom
import com.example.coffee.navigation.Screen
import com.example.coffee.ui.theme.Black80
import com.example.coffee.ui.theme.SnigletFamily

@Composable
fun SnackDetailsScreen(navController: NavController, imageRes: Int)
{

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
            CancelBottom({ navController.navigate(Screen.HomeScreen.route) })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()

        )
        {
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .padding(start=8.dp)
                    .offset(y=14.dp),
                painter = painterResource(id = R.drawable.coffee_beans),
                contentDescription = "star Icon",
                tint = Coffee
            )
            Text(
                modifier = Modifier.padding(top = 24.dp, start = 6.dp),
                text = "More Espresso, Less Depresso",
                color = Coffee,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily =SnigletFamily
            )
            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .padding(start=6.dp )
                    .offset(y=14.dp),
                painter = painterResource(id = R.drawable.coffee_beans),
                contentDescription = "star Icon",
                tint = Coffee
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(310.dp)
                .padding(start=10.dp)
            //  .background(color = Color(0xFFF5F5F5), shape = RoundedCornerShape(32.dp))
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 39.dp)
                    .fillMaxWidth()
                    .height(310.dp),
                painter = painterResource(id = imageRes),
                contentDescription = "selected snack"
            )
        }
        Row() {
            Text(
                modifier = Modifier.padding(top = 24.dp, start = 125.dp),
                text = "Bon appétit",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Black80,
                fontFamily = UrbanistFamily
            )
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .offset(y=20.dp)
                    .padding(start=8.dp),
                painter = painterResource(id =R.drawable.magic_wand),
                contentDescription = "selected snack"
            )
        }
        Spacer(modifier= Modifier.height(162.dp))
        Box(modifier=Modifier.padding(start=84.dp)) {
            ThankYouBottom({navController.navigate(Screen.HomeScreen.route)})
        }

    }
    }


