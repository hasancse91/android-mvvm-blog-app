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
    private val viewModel: BlogViewModel by viewModels { BlogViewModel.Factory }

    /*

        // Lazy with param
        private val viewModel1: BlogViewModel by viewModels { BlogViewModel.Factory }
        private val viewModel2 by viewModels<BlogViewModel> { BlogViewModel.Factory }
        private val viewModel3: BlogViewModel by lazy {
            ViewModelProvider(this, BlogViewModel.Factory)[BlogViewModel::class.java]
        }
    */

    //    private val viewModel: BlogViewModel by viewModels { BlogViewModel.Factory }
    //    private val viewModel: BlogViewModel by lazy {
    //        ViewModelProvider(this, BlogViewModel.Factory)[BlogViewModel::class.java]
    //    }

    /*
        // Lazy without param
        private val viewModel1: BlogViewModel by viewModels()
        private val viewModel2 by viewModels<BlogViewModel>()
        private val viewModel3 by lazy {
            ViewModelProvider(this)[BlogViewModel::class.java]
        }
        private val viewModel4 by lazy {
            ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[BlogViewModel::class.java]
        }
        private val viewModel5 by lazy {
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory()
            )[BlogViewModel::class.java]
        }
        */

    /*
        private lateinit var viewModel5: BlogViewModel
        private lateinit var viewModel1: BlogViewModel
        private lateinit var viewModel2: BlogViewModel
        private lateinit var viewModel3: BlogViewModel
        private lateinit var viewModel4: BlogViewModel*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel1 = ViewModelProvider(this, BlogViewModel.Factory).get(BlogViewModel::class.java)
//        viewModel2 = ViewModelProvider(this, BlogViewModel.Factory)[BlogViewModel::class.java]

//        viewModel1 = ViewModelProvider(this).get(BlogViewModel::class.java)
//        viewModel2 = ViewModelProvider(this)[BlogViewModel::class.java]
//        viewModel3 = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(BlogViewModel::class.java)
//        viewModel4 = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[BlogViewModel::class.java]

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