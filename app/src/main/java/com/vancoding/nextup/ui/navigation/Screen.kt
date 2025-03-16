package com.vancoding.nextup.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home : Screen()
    @Serializable
    object Auth : Screen()
}