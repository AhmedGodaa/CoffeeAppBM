package com.banquemisr.data.remote.dto

import com.google.gson.annotations.SerializedName

class SignInDto {
    @SerializedName("id")
    val id = 0

    @SerializedName("username")
    val username: String? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("token")
    val token: String? = null
}