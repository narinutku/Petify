package com.utku.petify.ui.model

data class SignUpRequest(
    val address: String,
    val birthDate: String,
    val eMail: String,
    val firstName: String,
    val gender: String,
    val lastName: String,
    val password: String,
    val phoneNumber: String
)