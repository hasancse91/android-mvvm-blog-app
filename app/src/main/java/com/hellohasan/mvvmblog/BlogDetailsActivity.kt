package com.hellohasan.mvvmblog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import com.hellohasan.mvvmblog.databinding.ActivityBlogDetailsBinding
import java.text.SimpleDateFormat
import java.util.Locale

class BlogDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBlogDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val blogResponse = intent.getSerializableExtra("blog") as BlogResponse

        Glide.with(binding.imageViewFeatured)
            .load(blogResponse.jetpackFeaturedMediaUrl)
            .into(binding.imageViewFeatured)

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val blogModifiedDate = inputFormat.parse(blogResponse.date)

        binding.textViewTitle.text = blogResponse.title.rendered
        binding.textViewDate.text = outputFormat.format(blogModifiedDate)
        binding.textViewExcerpt.text = Html.fromHtml(blogResponse.excerpt.rendered, Html.FROM_HTML_MODE_COMPACT)
        binding.textViewContent.text = Html.fromHtml(blogResponse.content.rendered, Html.FROM_HTML_MODE_COMPACT)
    }
}