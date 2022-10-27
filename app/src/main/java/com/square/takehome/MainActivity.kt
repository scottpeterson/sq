package com.square.takehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import com.square.takehome.api.ApiService
import com.square.takehome.main.EmployeeDirectoryScreen
import com.square.takehome.main.EmployeeDirectoryViewModel
import com.square.takehome.main.theme.ComposeAndroidSquareTheme
import com.square.takehome.repository.Repository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAndroidSquareTheme {
                Surface {
                    Scaffold {
                        EmployeeDirectoryScreen(
                            viewModel = EmployeeDirectoryViewModel(
                            )
                        )
                    }
                }
            }
        }
    }

}
