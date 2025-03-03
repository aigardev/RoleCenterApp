package com.aigardev.rolecenterapp.authentication

class AuthenticationDataSource {

    // Simulación de usuarios y contraseñas "hardcoded" (¡Solo para desarrollo inicial!)
    private val users = mapOf(
        "usuario1" to "clave1",
        "usuario2" to "clave2",
        "testuser" to "password",
        "admin" to "admin123",
        "123" to "123"
    )

    // Función para simular la autenticación.
    // En un escenario real, esto haría una llamada a una base de datos o servicio web.
    fun authenticate(username: String, password: String): Result<String> {
        // Verificamos si el usuario existe en nuestro mapa "hardcoded" y si la contraseña coincide.
        val storedPassword = users[username]
        if (storedPassword == password) {
            // Simulación de autenticación exitosa.
            // En un escenario real, aquí podríamos devolver información del usuario o un token.
            return Result.success("Autenticación Exitosa para: $username")
        } else {
            // Simulación de autenticación fallida.
            return Result.failure(Exception("Credenciales inválidas"))
        }
    }
}