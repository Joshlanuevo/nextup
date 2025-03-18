package com.vancoding.nextup.utils

import com.vancoding.nextup.data.network.model.AuthResponse

sealed class SignInState {
    object Default : SignInState()
    object Loading : SignInState()
    data class Success(val response: AuthResponse) : SignInState()
    data class Failure(val message: String) : SignInState()
}