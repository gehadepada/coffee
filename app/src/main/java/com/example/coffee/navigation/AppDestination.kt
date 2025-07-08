package com.example.coffee.navigation

sealed class Screen(val route :String){
    object HomeScreen:Screen("homeScreen")
    object CoffeeScreen:Screen("coffeeScreen")
    object CoffeeDetailsScreen:Screen("coffeeDetailsScreen")
    object CoffeeDoneScreen:Screen("coffeeDoneScreen")
    object CoffeeReadyScreen:Screen("coffeeReadyScreen")
    object SnakeScreen:Screen("snakeScreen")
    object SnakeDetailsScreen:Screen("snakeDetailsScreen")

}