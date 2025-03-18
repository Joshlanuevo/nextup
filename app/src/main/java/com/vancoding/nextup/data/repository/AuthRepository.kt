package com.vancoding.nextup.data.repository

import android.util.Log
import com.vancoding.nextup.data.network.api.AuthApi
import com.vancoding.nextup.data.network.model.AuthResponse
import com.vancoding.nextup.data.network.model.SignInRequest
import com.vancoding.nextup.data.network.model.SignUpRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApi: AuthApi,
) {
    suspend fun signUp(
        username: String,
        email: String,
        password: String
    ): Result<AuthResponse> {
        return runCatching {
            authApi.signUp(SignUpRequest(username, email, password)).takeIf {
                !it.accessToken.isNullOrEmpty() && !it.refreshToken.isNullOrEmpty() && it.user != null
            } ?: throw Exception("Invalid response structure from server")
        }
    }

    suspend fun signIn(email: String, password: String): Result<AuthResponse> {
        return runCatching { authApi.signIn(SignInRequest(email, password)) }
    }
}