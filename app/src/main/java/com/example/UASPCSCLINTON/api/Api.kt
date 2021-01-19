package com.example.UASPCSCLINTON.api

import com.example.UASPCSCLINTON.data.User
import com.example.UASPCSCLINTON.data.model.DetailUserResponse
import com.example.UASPCSCLINTON.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET ("search/users")
    @Headers ("Authorization: token  4344b5812305e1b7d7dc5a0e85c74edd8032307c")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers ("Authorization: token  4344b5812305e1b7d7dc5a0e85c74edd8032307c")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET ("users/{username}/followers")
    @Headers ("Authorization: token  4344b5812305e1b7d7dc5a0e85c74edd8032307c")
    fun getFollowers(
        @Path("username") username:String
    ): Call<ArrayList<User>>

    @GET ("users/{username}/following")
    @Headers ("Authorization: token  4344b5812305e1b7d7dc5a0e85c74edd8032307c")
    fun getFollowing(
        @Path("username") username:String
    ): Call<ArrayList<User>>
}