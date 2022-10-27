package com.square.takehome.main.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = SquareColors.White,
    onPrimary = SquareColors.Red,
    secondary = SquareColors.White,
    onSecondary = SquareColors.Red,
    background = SquareColors.White,
    onBackground = SquareColors.Red,
    surface = SquareColors.White,
    onSurface = SquareColors.Red
)

private val DarkColorPalette = darkColors(
    primary = SquareColors.Black,
    onPrimary = SquareColors.Red,
    secondary = SquareColors.Black,
    onSecondary = SquareColors.Red,
    background = SquareColors.Black,
    onBackground = SquareColors.Red,
    surface = SquareColors.Black,
    onSurface = SquareColors.Red
)

@Composable
fun ComposeAndroidSquareTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}