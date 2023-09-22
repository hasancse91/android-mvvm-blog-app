package com.hellohasan.mvvmblog.feature.blog_list.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellohasan.mvvmblog.databinding.ItemBlogPostBinding
import com.hellohasan.mvvmblog.feature.blog_details.view.BlogDetailsActivity
import com.hellohasan.mvvmblog.feature.blog_list.view_model.BlogItemUiModel

class BlogPostRecyclerViewAdapter(private val blogPostList: List<BlogItemUiModel>) :
    RecyclerView.Adapter<BlogPostRecyclerViewAdapter.BlogPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        val binding = ItemBlogPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BlogPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        val blogPost = blogPostList[position]
        holder.bind(blogPost)
    }

    override fun getItemCount(): Int {
        return blogPostList.size
    }

    inner class BlogPostViewHolder(private val binding: ItemBlogPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(blogPost: BlogItemUiModel) {
            Glide.with(itemView)
                .load(blogPost.imageUrl)
                .into(binding.imageViewFeatured)

            binding.textViewTitle.text = blogPost.title
            binding.textViewModifiedDate.text = blogPost.date

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, BlogDetailsActivity::class.java)
                intent.putExtra("blog", blogPost)
                binding.root.context.startActivity(intent)
            }
        }
    }
}