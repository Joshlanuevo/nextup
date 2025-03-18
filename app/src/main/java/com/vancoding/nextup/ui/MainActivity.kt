package com.vancoding.nextup.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vancoding.nextup.ui.navigation.AppNavGraph
import com.vancoding.nextup.ui.theme.NextUpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NextUpTheme {
                navController = rememberNavController()
                AppNavGraph(
                    navController = navController,
                )
            }
        }
    }
}