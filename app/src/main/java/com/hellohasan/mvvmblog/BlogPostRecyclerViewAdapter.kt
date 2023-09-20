package com.hellohasan.mvvmblog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellohasan.mvvmblog.databinding.ItemBlogPostBinding
import java.text.SimpleDateFormat
import java.util.Locale

class BlogPostRecyclerViewAdapter(private val blogPostList: List<BlogResponse>) :
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

        fun bind(blogPost: BlogResponse) {
            Glide.with(itemView)
                .load(blogPost.jetpackFeaturedMediaUrl)
                .into(binding.imageViewFeatured)

            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

            val blogModifiedDate = inputFormat.parse(blogPost.date)

            binding.textViewTitle.text = blogPost.title.rendered
            binding.textViewModifiedDate.text = outputFormat.format(blogModifiedDate)

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, BlogDetailsActivity::class.java)
                intent.putExtra("blog", blogPost)
                binding.root.context.startActivity(intent)
            }
        }
    }
}