package com.square.takehome.main.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.square.takehome.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold),
)

val Typography = Typography(

    defaultFontFamily = Roboto,

    subtitle1 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    subtitle2 = TextStyle(
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
    ),
    h1 = TextStyle(
        fontSize = 21.sp,
        fontWeight = FontWeight.Bold,
    ),
    h2 = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
    ),
    h3 = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    ),
    h4 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    ),
    h5 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    h6 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    ),
    body1 = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 25.sp
    ),
    body2 = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    ),
    overline = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal,
    )
)