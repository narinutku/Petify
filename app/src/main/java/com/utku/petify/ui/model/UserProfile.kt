package com.utku.petify.ui.model

data class UserProfile(
    val activated: Boolean,
    val address: String,
    val birthDate: String,
    val creationTime: String,
    val eMail: String,
    val firstName: String,
    val gender: String,
    val id: String,
    val lastName: String,
    val media: Any,
    val password: String,
    val phoneNumber: String,
    val username: String
)