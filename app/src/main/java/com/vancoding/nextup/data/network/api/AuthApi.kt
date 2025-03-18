package com.vancoding.nextup.data.network.api

import com.vancoding.nextup.data.network.config.AuthApiConfig
import com.vancoding.nextup.data.network.model.AuthResponse
import com.vancoding.nextup.data.network.model.SignInRequest
import com.vancoding.nextup.data.network.model.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST(AuthApiConfig.EndPoints.SIGN_UP)
    suspend fun signUp(
        @Body request: SignUpRequest,
    ): AuthResponse

    @POST(AuthApiConfig.EndPoints.SIGN_IN)
    suspend fun signIn(
        @Body request: SignInRequest,
    ): AuthResponse
}