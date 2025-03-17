package com.vancoding.nextup.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object SignIn : Screen()
    @Serializable
    object SignUp : Screen()
}