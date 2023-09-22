package com.hellohasan.mvvmblog.feature.blog_list.model

interface ModelCallback {
    fun onSuccess(list: List<BlogResponse>)
    fun onError(error: String)
}