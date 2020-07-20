package com.example.myapplication.data_sources

import com.example.myapplication.model.Comment
import com.example.myapplication.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts/{post_id}/comments")
    fun getPostComments(@Path("post_id") postId: Int): Call<List<Comment>>
}