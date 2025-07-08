package com.example.coffee.navigation

import com.example.coffee.composable.CoffeeSize

sealed class Screen(val route :String){
    object HomeScreen:Screen("homeScreen")
    object CoffeeScreen:Screen("coffeeScreen")
    object CoffeeDetailsScreen:Screen("coffeeDetailsScreen")
    object CoffeeDoneScreen : Screen("coffeeDoneScreen/{coffeeSize}") {
        fun withSize(size: CoffeeSize) = "coffeeDoneScreen/${size.name}"
    }
    object CoffeeReadyScreen:Screen("coffeeReadyScreen")
    object SnakeScreen:Screen("snakeScreen")
    object SnakeDetailsScreen : Screen("snakeDetailsScreen/{imageRes}") {
        fun withImageRes(imageRes: Int) = "snakeDetailsScreen/$imageRes"
    }

}