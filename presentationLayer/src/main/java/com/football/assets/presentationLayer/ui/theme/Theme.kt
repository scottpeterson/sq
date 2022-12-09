package com.football.assets.presentationLayer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = SquareColors.SeahawksNavy,
    onPrimary = SquareColors.White,
    secondary = SquareColors.SeahawksActionGreen,
    onSecondary = SquareColors.Black,
    background = SquareColors.White,
    onBackground = SquareColors.Black,
    surface = SquareColors.White,
    onSurface = SquareColors.Black
)

private val DarkColorPalette = darkColors(
    primary = SquareColors.SeahawksNavy,
    onPrimary = SquareColors.White,
    secondary = SquareColors.SeahawksActionGreen,
    onSecondary = SquareColors.Black,
    background = SquareColors.DarkThemeSurface,
    onBackground = SquareColors.White,
    surface = SquareColors.DarkThemeSurface,
    onSurface = SquareColors.White
)

@Composable
fun ComposeAndroidFootballAssetsTheme(
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