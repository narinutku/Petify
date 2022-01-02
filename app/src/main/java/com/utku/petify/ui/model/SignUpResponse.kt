package com.utku.petify.ui.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("activated")
    val activated: Boolean,
    @SerializedName("address")
    val address: String,
    @SerializedName("birthDate")
    val birthDate: String,
    @SerializedName("creationTime")
    val creationTime: String,
    @SerializedName("eMail")
    val eMail: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("media")
    val media: Any,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("username")
    val username: String
)