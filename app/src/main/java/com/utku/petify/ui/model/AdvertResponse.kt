package com.utku.petify.ui.model

data class AdvertResponse(
    val advertiserMail: String,
    val advertiserName: String,
    val advertiserPhoneNumber: String,
    val creationTime: String,
    val description: String,
    val id: String,
    val petColor: String,
    val petDesc: String,
    val petFamily: String,
    val petGender: String,
    val petName: String,
    val title: String,
    val type: String
)