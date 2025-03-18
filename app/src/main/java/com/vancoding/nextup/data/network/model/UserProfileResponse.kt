package com.vancoding.nextup.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserProfileResponse(
    val id: String,
    val username: String,
    val email: String,
)