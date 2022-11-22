package com.example.login.form.ui

sealed class NavRoutes(val route: String) {
    object Splash : NavRoutes("splash")
    object Login : NavRoutes("login")
    object List : NavRoutes("list")
    object Detail : NavRoutes("detail")
    object Search : NavRoutes("search")
}