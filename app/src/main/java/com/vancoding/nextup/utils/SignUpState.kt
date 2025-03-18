package com.vancoding.nextup.utils

import com.vancoding.nextup.data.network.model.AuthResponse

sealed class SignUpState {
    object Default : SignUpState()
    object Loading : SignUpState()
    data class Success(val response: AuthResponse) : SignUpState()
    data class Failure(val message: String) : SignUpState()
}