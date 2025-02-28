package com.aigardev.rolecenterapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/*
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)
*/

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    tertiary = AccentColor,
    background = LightBackgroundColor,
    surface = LightGrayColor,
    onPrimary = LightGrayColor,
    onSecondary = LightGrayColor,
    onTertiary = PrimaryColor,
    onBackground = PrimaryColor,
    onSurface = PrimaryColor,
    primaryContainer = Purple80, // <-- ¡EJEMPLO DE ROL ADICIONAL (PUEDE SER UN COLOR POR DEFECTO INICIALMENTE)!
    secondaryContainer = PurpleGrey80, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    tertiaryContainer = Pink80, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onPrimaryContainer = Purple40, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onSecondaryContainer = PurpleGrey40, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onTertiaryContainer = Pink40, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    surfaceVariant = LightGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL (PUEDE SER UN COLOR POR DEFECTO INICIALMENTE)!
    onSurfaceVariant = PrimaryColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    inverseSurface = DarkGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    inverseOnSurface = PrimaryColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    error = Color.Red, // <-- ¡EJEMPLO DE ROL ADICIONAL (PUEDE SER UN COLOR POR DEFECTO INICIALMENTE)!
    onError = Color.White, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    errorContainer = Color.Red.copy(0.3f), // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onErrorContainer = Color.Black, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    outline = DarkGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    outlineVariant = LightGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    scrim = Color.Black, // <-- ¡EJEMPLO DE ROL ADICIONAL!
)

private val DarkColorScheme = darkColorScheme(
    primary = AccentColor,
    secondary = LightBackgroundColor,
    tertiary = SecondaryColor,
    background = PrimaryColor,
    surface = PrimaryColor,
    onPrimary = PrimaryColor,
    onSecondary = PrimaryColor,
    onTertiary = LightBackgroundColor,
    onBackground = LightGrayColor,
    onSurface = LightGrayColor,
    primaryContainer = Purple40, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    secondaryContainer = PurpleGrey40, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    tertiaryContainer = Pink40, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onPrimaryContainer = Purple80, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onSecondaryContainer = PurpleGrey80, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onTertiaryContainer = Pink80, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    surfaceVariant = DarkGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL (PUEDE SER UN COLOR POR DEFECTO INICIALMENTE)!
    onSurfaceVariant = LightGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    inverseSurface = LightBackgroundColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    inverseOnSurface = LightGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    error = Color.Red, // <-- ¡EJEMPLO DE ROL ADICIONAL (PUEDE SER UN COLOR POR DEFECTO INICIALMENTE)!
    onError = Color.White, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    errorContainer = Color.Red.copy(0.3f), // <-- ¡EJEMPLO DE ROL ADICIONAL!
    onErrorContainer = Color.Black, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    outline = LightGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    outlineVariant = DarkGrayColor, // <-- ¡EJEMPLO DE ROL ADICIONAL!
    scrim = Color.Black, // <-- ¡EJEMPLO DE ROL ADICIONAL!
)

@Composable
fun RoleCenterAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}