package com.banquemisr.data.remote.dto

import com.google.gson.annotations.SerializedName

class SignUpDto {
    @SerializedName("username")
    val username: String? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("password")
    val password: String? = null
}