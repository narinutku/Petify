package com.utku.petify.ui.model

import com.google.gson.annotations.SerializedName

data class User (@SerializedName("id")
            val id_: Int = 0,
            @SerializedName("title")
            val title: String = "",
            @SerializedName("body")
            val body: String = "",
            @SerializedName("userId")
            val userId: Int = 0)