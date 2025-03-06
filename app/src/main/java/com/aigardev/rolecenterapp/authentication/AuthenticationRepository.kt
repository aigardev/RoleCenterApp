package com.aigardev.rolecenterapp.authentication

interface AuthenticationRepository {
    suspend fun login(username: String, password: String): Boolean // Cambio de nombre y tipo de retorno
}