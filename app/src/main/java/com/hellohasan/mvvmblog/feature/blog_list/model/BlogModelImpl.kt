package com.hellohasan.mvvmblog.feature.blog_list.model

import com.hellohasan.mvvmblog.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class BlogModelImpl : BlogModel {

    private val blogApiInterface = RetrofitClient.client.create<BlogApiInterface>()

    override fun fetchBlogList(callback: ModelCallback) {

        val apiCall = blogApiInterface.getBlogList()

        apiCall.enqueue(object : Callback<List<BlogResponse>> {
            override fun onResponse(
                call: Call<List<BlogResponse>>,
                response: Response<List<BlogResponse>>
            ) {
                val blogList = response.body()

                if (blogList?.isEmpty() == true) {
                    callback.onError("Content not found")
                } else {
                    callback.onSuccess(blogList!!)
                }
            }

            override fun onFailure(call: Call<List<BlogResponse>>, t: Throwable) {
                callback.onError(t.message ?: "Something went wrong")
            }
        })
    }
}