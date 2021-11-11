package com.example.imguram.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imguram.data.ImgurRepository
import com.example.libimgur.models.GalleryTagsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {
    private val repo = ImgurRepository()

    private val _tags = MutableLiveData<List<GalleryTagsResponse.Data.Tag?>>()
    val tags: LiveData<List<GalleryTagsResponse.Data.Tag?>> = _tags

    fun fetchTags() = viewModelScope.launch(Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }
}