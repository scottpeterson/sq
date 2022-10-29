package com.square.takehome.main.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = SquareColors.CashAppGreen,
    onPrimary = SquareColors.White,
    secondary = SquareColors.White,
    onSecondary = SquareColors.Black,
    background = SquareColors.White,
    onBackground = SquareColors.Black,
    surface = SquareColors.White,
    onSurface = SquareColors.Black
)

private val DarkColorPalette = darkColors(
    primary = SquareColors.CashAppGreen,
    onPrimary = SquareColors.Black,
    secondary = SquareColors.Black,
    onSecondary = SquareColors.CashAppGreen,
    background = SquareColors.Black,
    onBackground = SquareColors.CashAppGreen,
    surface = SquareColors.Black,
    onSurface = SquareColors.CashAppGreen
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