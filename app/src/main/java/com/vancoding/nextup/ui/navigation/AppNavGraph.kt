package com.vancoding.nextup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vancoding.nextup.ui.screens.auth.AuthenticationScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignIn,
    ) {
        composable<Screen.SignIn> {
            AuthenticationScreen(
                isSignInScreen = true,
                onSignUpClick = {
                    navController.navigate(Screen.SignUp)
                },
            )
        }
        composable<Screen.SignUp> {
            AuthenticationScreen(
                isSignInScreen = false,
                onSignUpClick = {
                    navController.navigate(Screen.SignIn)
                },
            )
        }
    }
}