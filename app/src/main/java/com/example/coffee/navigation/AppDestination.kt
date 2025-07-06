package com.example.coffee.navigation

sealed class Screen(val route :String){
    object HomeScreen:Screen("homeScreen")
    object CoffeeScreen:Screen("coffeeScreen")
}