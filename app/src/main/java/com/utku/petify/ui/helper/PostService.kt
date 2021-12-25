package com.utku.petify.ui.helper

import com.utku.petify.ui.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface PostService {
    @POST("api/v1/auth/login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Call<List<User>>

    @POST("api/v1/register")
    fun register(

        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("birthDate") birthDate: String,
        @Query("phoneNumber") phoneNumber: String,
        @Query("eMail") eMail: String,
        @Query("gender") gender: String,
        @Query("password") password: String
    ): Call<String>

    @GET("api/v1/my-account")
    fun getProfile(

    ): Call<User>
    @PUT("api/v1/register")
    fun updateProfile(

        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("birthDate") birthDate: String,
        @Query("phoneNumber") phoneNumber: String,
        @Query("eMail") eMail: String,
        @Query("gender") gender: String,
        @Query("password") password: String
    ): Call<String>

    @GET("api/v1/register")
    fun accountVerify(
        @Query("verificationToken") verificationToken: String,

    ): Call<String>

}