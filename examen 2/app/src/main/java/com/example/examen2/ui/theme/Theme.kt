package com.example.examen2.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Esquema de colores oscuro
private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    secondary = Green80,
    tertiary = Teal80
)

// Esquema de colores claro
private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    secondary = Green40,
    tertiary = Teal40
)

@Composable
fun ProyectoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color está disponible a partir de Android 12+
    dynamicColor: Boolean = true,
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

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
