package com.aigardev.rolecenterapp.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit, // Callback para éxito de login
    loginViewModel: LoginViewModel // Recibimos el LoginViewModel (con viewModel())
) {
    // Observamos el estado de la UI desde el ViewModel
    //val loginUiState by loginViewModel.loginUiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido a RollSheet App", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = loginViewModel.username.value, // Valor desde el ViewModel
            onValueChange = { loginViewModel.onUsernameChanged(it) }, // Actualización a través del ViewModel
            label = { Text("Usuario") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = loginViewModel.password.value, // Valor desde el ViewModel
            onValueChange = { loginViewModel.onPasswordChanged(it) }, // Actualización a través del ViewModel
            label = { Text("Contraseña") },
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                coroutineScope.launch { // Lanza una corrutina
                    if (loginViewModel.login()) {
                        onLoginSuccess()
                    } else {
                        showError = true
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Login")
        }

        // Reaccionamos a los diferentes estados del LoginUiState
        /*
        when (val uiState = loginUiState) {
            LoginViewModel.LoginUiState.Initial -> {} // No hacemos nada en el estado inicial
            LoginViewModel.LoginUiState.Loading -> { // Estado de carga
                Spacer(modifier = Modifier.height(8.dp))
                CircularProgressIndicator() // Mostramos un indicador de carga
            }
            LoginViewModel.LoginUiState.Success -> { // Estado de éxito
                LaunchedEffect(Unit) { // LaunchedEffect para ejecutar código una vez cuando el estado es Success
                    onLoginSuccess() // Llamamos al callback de éxito para navegar al Dashboard
                }
            }
            is LoginViewModel.LoginUiState.Error -> { // Estado de error
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = uiState.message, // Mostramos el mensaje de error
                    color = MaterialTheme.colorScheme.error // Con color de error del tema
                )
            }
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {},
        loginViewModel = viewModel() // Usamos viewModel() para obtener el LoginViewModel
    )
}