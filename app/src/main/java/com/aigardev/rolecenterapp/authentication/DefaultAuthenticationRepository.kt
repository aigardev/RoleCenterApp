package com.aigardev.rolecenterapp.authentication

class DefaultAuthenticationRepository (
    private val authenticationDataSource: AuthenticationDataSource
) : AuthenticationRepository {

    override suspend fun login(username: String, password: String): Boolean {
        //Simulamos el login con datos hardcodeados
        return username == "admin" && password == "admin"
    }
}