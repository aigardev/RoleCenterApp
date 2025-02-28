package com.aigardev.rolecenterapp.authentication

class DefaultAuthenticationRepository(
    private val authenticationDataSource: AuthenticationDataSource
) : AuthenticationRepository {

    override suspend fun authenticate(username: String, password: String): Result<String> {
        // Simplemente delegamos la llamada al AuthenticationDataSource
        return authenticationDataSource.authenticate(username, password)
    }
}