package com.hellohasan.mvvmblog.feature.blog_list.model

import com.hellohasan.mvvmblog.feature.blog_list.model.BlogResponse
import retrofit2.Call
import retrofit2.http.GET

interface BlogApiInterface {

    @GET("posts")
    fun getBlogList() : Call<List<BlogResponse>>
}