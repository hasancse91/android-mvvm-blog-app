package com.hellohasan.mvvmblog.blog_list.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellohasan.mvvmblog.blog_list.model.BlogItemUiModel
import com.hellohasan.mvvmblog.blog_list.model.BlogListModel
import com.hellohasan.mvvmblog.blog_list.model.BlogListModelImpl
import com.hellohasan.mvvmblog.blog_list.model.ModelCallback
import com.hellohasan.mvvmblog.blog_list.model.data.BlogResponse
import java.text.SimpleDateFormat
import java.util.Locale

class BlogListViewModel(private val model : BlogListModel) : ViewModel() {

    val showLoaderLiveData = MutableLiveData<Boolean>()
    val showErrorLiveData = MutableLiveData<String>()
    val blogListUiModelLiveData : MutableLiveData<List<BlogItemUiModel>> by lazy {
        MutableLiveData<List<BlogItemUiModel>>()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val model: BlogListModel = BlogListModelImpl()
                return BlogListViewModel(model) as T
            }
        }
    }

    fun getBlogList() {
        showLoaderLiveData.postValue(true)

        model.getBlogList(object : ModelCallback {
            override fun onSuccess(blogResponseList: List<BlogResponse>) {
                val blogListUiModel = getBlogUiModelList(blogResponseList)
                showLoaderLiveData.postValue(false)
                blogListUiModelLiveData.postValue(blogListUiModel)
            }

            override fun onError(error: String) {
                showLoaderLiveData.postValue(false)
                showErrorLiveData.postValue(error)
            }
        })

    }

    private fun getBlogUiModelList(blogResponseList: List<BlogResponse>) : List<BlogItemUiModel> {
        val blogUiModelList = mutableListOf<BlogItemUiModel>()

        blogResponseList.forEach {

            val blogUiModel = BlogItemUiModel(
                title = it.title.rendered,
                imageUrl = it.jetpackFeaturedMediaUrl,
                date = getFormatterDate(it.date),
                content = it.content.rendered,
                excerpt = it.excerpt.rendered
            )

            blogUiModelList.add(blogUiModel)
        }

        return blogUiModelList
    }

    private fun getFormatterDate(dateInput: String) : String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())

        val blogModifiedDate = inputFormat.parse(dateInput)

        return outputFormat.format(blogModifiedDate)
    }
}