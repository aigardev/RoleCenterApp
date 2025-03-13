package com.aigardev.rolecenterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable // Import CORRECTO para composable
import androidx.navigation.compose.rememberNavController
import com.aigardev.rolecenterapp.ui.theme.RoleCenterAppTheme
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.aigardev.rolecenterapp.authentication.AuthenticationDataSource
import com.aigardev.rolecenterapp.authentication.DefaultAuthenticationRepository
import com.aigardev.rolecenterapp.authentication.LoginScreen
import com.aigardev.rolecenterapp.authentication.LoginViewModel
import com.aigardev.rolecenterapp.charactersheets.ListSheetsScreen
import com.aigardev.rolecenterapp.dashboard.DashboardScreen
//import com.aigardev.rolecenterapp.ui.screens.games.CreateGameScreen
//import com.aigardev.rolecenterapp.ui.screens.games.ListGamesScreen
//import com.aigardev.rolecenterapp.ui.screens.sheet.CreateSheetScreen
//import com.aigardev.rolecenterapp.ui.screens.sheet.ListSheetsScreen
import com.aigardev.rolecenterapp.core.navigation.Screen // Import CORRECTO de Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoleCenterAppTheme() {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Creamos las instancias del DataSource y Repository
    val authenticationDataSource = AuthenticationDataSource()
    val authenticationRepository = DefaultAuthenticationRepository(authenticationDataSource)

    // Creamos el LoginViewModel, pasando el AuthenticationRepository como dependencia
    val loginViewModel: LoginViewModel = viewModel(
        factory = viewModelFactory {
            initializer {
                LoginViewModel(authenticationRepository = authenticationRepository)
            }
        }
    )

    val isLoggedIn by loginViewModel.isLoggedIn.collectAsState() // OBSERVA el StateFlow

    NavHost(navController = navController, startDestination = if (isLoggedIn) Screen.Dashboard.route else Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                loginViewModel = loginViewModel
            )
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController, loginViewModel = loginViewModel) // navController como parámetro
        }
        /*
        composable(Screen.CreateSheet.route) {
            CreateSheetScreen()
        }*/
        composable(Screen.ListSheets.route) {
            ListSheetsScreen(navController = navController)
        }
        /*
        composable(Screen.CreateGame.route) {
            CreateGameScreen()
        }
        composable(Screen.ListGames.route) {
            ListGamesScreen()
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoleCenterAppTheme {
        AppNavigation() // Vista previa de la función AppNavigation
    }
}