package com.utku.petify.ui.model

import com.google.gson.annotations.SerializedName

data class User (@SerializedName("authenticationToken")
            val authenticationToken: String = "",
            @SerializedName("refreshToken")
            val refreshToken: String = "",
            @SerializedName("expiresAt")
            val expiresAt: String = "",
            @SerializedName("username")
            val username: String = "")