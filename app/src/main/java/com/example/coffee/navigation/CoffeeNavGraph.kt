package com.example.coffee.navigation

import com.example.coffee.screens.SnackDetailsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.coffee.R
import com.example.coffee.screens.SnackScreen
import com.example.coffee.screens.CoffeeDetailsScreen
import com.example.coffee.screens.CoffeeDoneScreen
import com.example.coffee.screens.CoffeeReadyScreen
import com.example.coffee.screens.CoffeeScreen
import com.example.coffee.screens.HomeScreen


@Composable
fun CoffeeNavGraph(navController:NavHostController)
{
    NavHost(navController , startDestination =(Screen.HomeScreen.route)) {
        composable(Screen.HomeScreen.route) { HomeScreen(navController) }
        composable(Screen.CoffeeScreen.route) { CoffeeScreen(navController) }
        composable(Screen.CoffeeDetailsScreen.route) { CoffeeDetailsScreen(navController) }
        composable(Screen.CoffeeDoneScreen.route) { CoffeeDoneScreen(navController) }
        composable(Screen.CoffeeReadyScreen.route) { CoffeeReadyScreen(navController) }
        composable(Screen.SnakeScreen.route) { SnackScreen(navController) }
        composable(
            route = Screen.SnakeDetailsScreen.route,
            arguments = listOf(navArgument("imageRes") {
                type = NavType.IntType
            })
        ) { backStack ->
            // read the argument:
            val imageRes = backStack.arguments?.getInt("imageRes") ?: R.drawable.cookies
            SnackDetailsScreen(navController, imageRes)
        }




    }

}