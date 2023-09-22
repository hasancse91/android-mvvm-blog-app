package com.hellohasan.mvvmblog.feature.blog_list.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellohasan.mvvmblog.databinding.ActivityBlogListBinding
import com.hellohasan.mvvmblog.feature.blog_list.view_model.BlogViewModel

class BlogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogListBinding
    private val viewModel: BlogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getBlogList()

        viewModel.showLoader.observe(this) { isVisible ->
            binding.progressBar.isVisible = isVisible
        }

        viewModel.showError.observe(this) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.blogItemUiModelList.observe(this) { blogList ->
            if (blogList.isNotEmpty()) {
                val layoutManager = LinearLayoutManager(this)
                binding.recyclerView.layoutManager = layoutManager

                val adapter = BlogPostRecyclerViewAdapter(blogList)
                binding.recyclerView.adapter = adapter

                binding.progressBar.isVisible = false
            }
        }
    }
}