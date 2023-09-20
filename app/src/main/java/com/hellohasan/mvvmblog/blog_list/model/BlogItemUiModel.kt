package com.hellohasan.mvvmblog.blog_list.model

import java.io.Serializable

data class BlogItemUiModel(
    val title: String,
    val imageUrl: String,
    val date: String,
    val content: String,
    val excerpt: String
) : Serializable
