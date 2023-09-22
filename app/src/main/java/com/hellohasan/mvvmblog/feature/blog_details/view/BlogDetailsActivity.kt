package com.hellohasan.mvvmblog.feature.blog_details.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import com.hellohasan.mvvmblog.databinding.ActivityBlogDetailsBinding
import com.hellohasan.mvvmblog.feature.blog_list.view_model.BlogItemUiModel

class BlogDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBlogDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blogUiModel = intent.getSerializableExtra("blog") as BlogItemUiModel

        Glide.with(binding.imageViewFeatured)
            .load(blogUiModel.imageUrl)
            .into(binding.imageViewFeatured)

        binding.textViewTitle.text = blogUiModel.title
        binding.textViewDate.text = blogUiModel.date
        binding.textViewExcerpt.text = Html.fromHtml(blogUiModel.excerpt, Html.FROM_HTML_MODE_COMPACT)
        binding.textViewContent.text = Html.fromHtml(blogUiModel.content, Html.FROM_HTML_MODE_COMPACT)
    }
}