package com.hellohasan.mvvmblog.feature.blog_list.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hellohasan.mvvmblog.feature.blog_list.model.BlogModel
import com.hellohasan.mvvmblog.feature.blog_list.model.BlogModelImpl
import com.hellohasan.mvvmblog.feature.blog_list.model.BlogResponse
import com.hellohasan.mvvmblog.feature.blog_list.model.ModelCallback
import java.text.SimpleDateFormat
import java.util.Locale

class BlogViewModel : ViewModel() {

    private val blogModel : BlogModel = BlogModelImpl()

    val showLoader: MutableLiveData<Boolean> = MutableLiveData(false)
    val showError: MutableLiveData<String> = MutableLiveData("")
    val blogItemUiModelList: MutableLiveData<List<BlogItemUiModel>> = MutableLiveData()

    fun getBlogList() {

        showLoader.postValue(true)

        blogModel.fetchBlogList(object : ModelCallback{
            override fun onSuccess(list: List<BlogResponse>) {

                val blogListUiModel : List<BlogItemUiModel> = getBlogUiModelList(list)

                blogItemUiModelList.postValue(blogListUiModel)
                showLoader.postValue(false)
            }

            override fun onError(error: String) {
                showLoader.postValue(false)
                showError.postValue(error)
            }

        })
    }

    private fun getBlogUiModelList(blogResponseList: List<BlogResponse>) : List<BlogItemUiModel> {
        val blogUiModelList = mutableListOf<BlogItemUiModel>()

        blogResponseList.forEach {

            val blogUiModel = BlogItemUiModel(
                title = it.title.rendered,
                imageUrl = it.jetpackFeaturedMediaUrl,
                date = getFormattedDate(it.date),
                content = it.content.rendered,
                excerpt = it.excerpt.rendered
            )

            blogUiModelList.add(blogUiModel)
        }

        return blogUiModelList
    }

    private fun getFormattedDate(dateInput: String) : String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val blogModifiedDate = inputFormat.parse(dateInput)

        return outputFormat.format(blogModifiedDate)
    }
}