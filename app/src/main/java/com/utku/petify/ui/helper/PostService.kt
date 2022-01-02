package com.utku.petify.ui.helper

import com.utku.petify.ui.model.*
import retrofit2.Call
import retrofit2.http.*

interface PostService {

    @POST("auth/login")
    fun login(
     @Body login: Login
    ): Call<User>

    @POST("register")
    fun register(
@Body signUpRequest: SignUpRequest
    ): Call<SignUpResponse>

    @GET("users/all")
    fun getProfile(

    ): Call<List<UserProfile>>
    @PUT("update-profile")
    fun updateProfile(

        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("birthDate") birthDate: String,
        @Query("phoneNumber") phoneNumber: String,
        @Query("eMail") eMail: String,
        @Query("gender") gender: String,
        @Query("password") password: String
    ): Call<String>

    @GET("account-verify")
    fun accountVerify(
        @Query("verificationToken") verificationToken: String,

    ): Call<String>

}