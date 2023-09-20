package com.hellohasan.mvvmblog.network

import com.hellohasan.mvvmblog.BlogResponse
import retrofit2.Call
import retrofit2.http.GET

interface BlogApiInterface {

    @GET("posts")
    fun getBlogList() : Call<List<BlogResponse>>
}