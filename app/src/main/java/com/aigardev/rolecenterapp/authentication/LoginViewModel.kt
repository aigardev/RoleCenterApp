package com.aigardev.rolecenterapp.authentication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()

    var username = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    fun onUsernameChanged(newValue: String) {
        username.value = newValue
    }

    fun onPasswordChanged(newValue: String) {
        password.value = newValue
    }

    suspend fun login(): Boolean {
        _loginUiState.value = LoginUiState.Loading

        val result = authenticationRepository.login(username.value, password.value)

        if (result) {
            _loginUiState.value = LoginUiState.Success
            _isLoggedIn.value = true
        } else {
            _loginUiState.value = LoginUiState.Error("Usuario o contraseña incorrectos")
        }
        return result // Devuelve el resultado
    }

    fun logout() {
        viewModelScope.launch {
            // authenticationRepository.logout() // Si tuvieras una función de logout en el repositorio
            _isLoggedIn.value = false
        }
    }

    sealed class LoginUiState {
        object Initial : LoginUiState()
        object Loading : LoginUiState()
        object Success : LoginUiState()
        data class Error(val message: String) : LoginUiState()
    }
}