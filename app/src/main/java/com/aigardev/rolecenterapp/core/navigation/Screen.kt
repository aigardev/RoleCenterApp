package com.aigardev.rolecenterapp.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object CreateSheet : Screen("create_sheet")
    object ListSheets : Screen("list_sheets")
    object CreateGame : Screen("create_game")
    object ListGames : Screen("list_games")
}