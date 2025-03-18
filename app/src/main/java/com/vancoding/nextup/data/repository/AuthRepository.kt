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
        password: String,
    ): Result<AuthResponse> {
        return try {
            Log.i("AuthRepository", "Attempting to sign up user: $username")
            val response = authApi.signUp(SignUpRequest(username, email, password))
            Log.i("AuthRepository", "Sign-up successful for user: $username")
            Result.success(response)
        } catch (e: Exception) {
            Log.e("AuthRepository", "Sign-up failed: ${e.message}")
            Result.failure(Exception("An error occurred: ${e.message}"))
        }
    }

    suspend fun signIn(
        email: String,
        password: String,
    ): Result<AuthResponse> {
        return try {
            Log.i("AuthRepository", "Attempting to sign in with email: $email")
            val response = authApi.signIn(SignInRequest(email, password))
            Log.i("AuthRepository", "Sign-in successful for email: $email")
            Result.success(response)
        } catch (e: Exception) {
            Log.e("AuthRepository", "Sign-in failed: ${e.message}")
            Result.failure(Exception("An error occurred: ${e.message}"))
        }
    }
}