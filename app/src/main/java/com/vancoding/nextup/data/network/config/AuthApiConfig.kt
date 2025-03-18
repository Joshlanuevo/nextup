package com.vancoding.nextup.data.network.config

object AuthApiConfig {

    const val BASE_URL = "http://10.0.2.2:3000"
    const val TIMEOUT_SECONDS = 30L

    object EndPoints {
        const val SIGN_UP = "/api/auth/register"
        const val SIGN_IN = "/api/auth/login"
    }
}