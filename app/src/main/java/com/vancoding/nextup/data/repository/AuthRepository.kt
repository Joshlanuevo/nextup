package com.vancoding.nextup.data.repository

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
        password: String,
    ): Result<AuthResponse> {
        return try {
            val response = authApi.signUp(SignUpRequest(username, email, password))
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(Exception("An error occurred: ${e.message}"))
        }
    }

    suspend fun signIn(
        email: String,
        password: String,
    ): Result<AuthResponse> {
        return try {
            val response = authApi.signIn(SignInRequest(email, password))
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(Exception("An error occurred: ${e.message}"))
        }
    }
}