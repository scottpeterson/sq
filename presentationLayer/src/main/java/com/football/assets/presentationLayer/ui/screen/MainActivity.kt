package com.football.assets.presentationLayer.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.football.assets.presentationLayer.ui.theme.ComposeAndroidFootballAssetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAndroidFootballAssetsTheme {
                Surface {
                    EmployeeDirectoryScreen()
                }
            }
        }
    }
}
