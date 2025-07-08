package com.example.coffee.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coffee.navigation.Screen.SnakeScreen
import com.example.coffee.screens.CoffeeDetailsScreen
import com.example.coffee.screens.CoffeeDoneScreen
import com.example.coffee.screens.CoffeeReadyScreen
import com.example.coffee.screens.CoffeeScreen
import com.example.coffee.screens.HomeScreen
import com.example.coffee.screens.SnackScreen

@Composable
fun CoffeeNavGraph(navController:NavHostController)
{
    NavHost(navController , startDestination =(Screen.HomeScreen.route)){
        composable(Screen.HomeScreen.route) { HomeScreen(navController) }
        composable(Screen.CoffeeScreen.route) { CoffeeScreen(navController) }
        composable(Screen.CoffeeDetailsScreen.route) { CoffeeDetailsScreen(navController) }
        composable(Screen.CoffeeDoneScreen.route) { CoffeeDoneScreen(navController) }
        composable(Screen.CoffeeReadyScreen.route) { CoffeeReadyScreen(navController) }
        composable(Screen.SnakeScreen.route) { SnackScreen(navController) }



    }

}