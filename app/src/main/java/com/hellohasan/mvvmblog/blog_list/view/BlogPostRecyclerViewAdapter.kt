package com.hellohasan.mvvmblog.blog_list.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellohasan.mvvmblog.blog_details.BlogDetailsActivity
import com.hellohasan.mvvmblog.blog_list.model.BlogItemUiModel
import com.hellohasan.mvvmblog.databinding.ItemBlogPostBinding

class BlogPostRecyclerViewAdapter(private val blogList: List<BlogItemUiModel>) :
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
        val blogPost = blogList[position]
        holder.bind(blogPost)
    }

    override fun getItemCount(): Int {
        return blogList.size
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