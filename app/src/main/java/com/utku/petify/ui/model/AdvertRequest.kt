package com.utku.petify.ui.model

data class AdvertRequest(
    val description: String,
    val petColor: String,
    val petDesc: String,
    val petFamily: String,
    val petGender: String,
    val petName: String,
    val title: String,
    val type: String
)