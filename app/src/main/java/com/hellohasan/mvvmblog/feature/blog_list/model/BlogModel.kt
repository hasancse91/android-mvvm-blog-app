package com.hellohasan.mvvmblog.feature.blog_list.model

interface BlogModel {
    fun fetchBlogList(callback: ModelCallback)
}