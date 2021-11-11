package com.example.imguram.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imguram.data.ImgurRepository
import com.example.libimgur.models.TagResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {
    private val repo = ImgurRepository()

    private val _images = MutableLiveData<List<TagResponse.Data.Item>>()
    val images: LiveData<List<TagResponse.Data.Item>> = _images

    fun fetchTag(tagName: String) = viewModelScope.launch(Dispatchers.IO) {
        _images.postValue(repo.getTag(tagName))
    }
}