package com.example.myapplication.repository

import com.example.myapplication.model.Comment
import com.example.myapplication.model.Post

interface IRepository {

    fun getPosts(callback: Callback<List<Post>>)
    fun getPostComments(postId: Int, callback: Callback<List<Comment>>)

    interface Callback<T> {
        fun onSuccess(response: T)
        fun onFailure(errorMessage: String)
    }
}