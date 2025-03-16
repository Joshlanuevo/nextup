package com.vancoding.nextup.ui.screens.auth

import androidx.compose.runtime.Composable

@Composable
fun AuthenticationScreen(
    isSignInScreen: Boolean,
) {
    val buttonText = if (isSignInScreen) "Sign In" else "Sign Up"
}