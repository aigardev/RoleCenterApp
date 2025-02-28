package com.aigardev.rolecenterapp.authentication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authenticationRepository: AuthenticationRepository // Inyección de dependencia del Repository
) : ViewModel() {

    // Estado de la UI para la pantalla de Login
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState

    var username = mutableStateOf("") // Estado para el campo de usuario
        private set // Solo el ViewModel puede modificarlo directamente

    var password = mutableStateOf("") // Estado para el campo de contraseña
        private set // Solo el ViewModel puede modificarlo directamente

    fun onUsernameChanged(newValue: String) {
        username.value = newValue
    }

    fun onPasswordChanged(newValue: String) {
        password.value = newValue
    }

    fun login() {
        _loginUiState.value = LoginUiState.Loading // Indicamos que el login está en progreso

        viewModelScope.launch { // Lanzamos una corrutina en el scope del ViewModel
            val result = authenticationRepository.authenticate(username.value, password.value) // Llamamos al Repository para autenticar

            if (result.isSuccess) {
                // Autenticación exitosa
                _loginUiState.value = LoginUiState.Success
            } else {
                // Autenticación fallida
                _loginUiState.value = LoginUiState.Error(result.exceptionOrNull()?.message ?: "Error desconocido")
            }
        }
    }

    // Definimos los posibles estados de la UI de Login como una clase sellada
    sealed class LoginUiState {
        object Initial : LoginUiState() // Estado inicial, pantalla recién cargada
        object Loading : LoginUiState() // Estado de "cargando", mientras se verifica el login
        object Success : LoginUiState()   // Estado de "éxito", login correcto
        data class Error(val message: String) : LoginUiState() // Estado de "error", login fallido, con mensaje de error
    }
}