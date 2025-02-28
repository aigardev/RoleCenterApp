package com.aigardev.rolecenterapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.aigardev.rolecenterapp.authentication.AuthenticationDataSource
import com.aigardev.rolecenterapp.authentication.DefaultAuthenticationRepository
import com.aigardev.rolecenterapp.authentication.LoginScreen
import com.aigardev.rolecenterapp.authentication.LoginViewModel
import com.aigardev.rolecenterapp.dashboard.DashboardScreen
import com.aigardev.rolecenterapp.ui.theme.RoleCenterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoleCenterAppTheme() {
                AppNavigation() // Llamamos a la función que gestiona la navegación
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val isLoggedIn = remember { mutableStateOf(false) }

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


    if (isLoggedIn.value) {
        DashboardScreen()
    } else {
        LoginScreen(
            onLoginSuccess = { isLoggedIn.value = true },
            loginViewModel = loginViewModel // Pasamos el LoginViewModel a LoginScreen
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoleCenterAppTheme {
        AppNavigation() // Vista previa de la función AppNavigation
    }
}