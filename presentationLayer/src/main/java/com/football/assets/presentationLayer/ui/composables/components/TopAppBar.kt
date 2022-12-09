package com.football.assets.main

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTopBar(
    title: @Composable() () -> Unit,
    color: Color = MaterialTheme.colors.primary,
    navigationIcon: @Composable() (() -> Unit)? = null
) {}