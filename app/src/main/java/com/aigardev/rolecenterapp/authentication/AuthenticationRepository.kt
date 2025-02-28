package com.aigardev.rolecenterapp.authentication

interface AuthenticationRepository {
    suspend fun authenticate(username: String, password: String): Result<String>
}