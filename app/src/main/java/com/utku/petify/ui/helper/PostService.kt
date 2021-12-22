package com.utku.petify.ui.helper

import com.utku.petify.ui.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("posts")
    fun listPost(@Query("userId") userId: String): Call<List<User>>
}