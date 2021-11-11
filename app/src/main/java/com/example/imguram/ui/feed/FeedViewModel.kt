package com.example.imguram.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imguram.data.ImgurRepository
import com.example.libimgur.models.GalleryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val repo = ImgurRepository()
    private val _feed = MutableLiveData<List<GalleryResponse.Data>>()
    val feed : LiveData<List<GalleryResponse.Data>> = _feed

    fun updateFeed(feedType: String){
        viewModelScope.launch(Dispatchers.IO) {
            when(feedType){
                "hot" -> _feed.postValue(repo.getHotFeed() as List<GalleryResponse.Data>?)
                "top" -> _feed.postValue(repo.getTopFeed() as List<GalleryResponse.Data>?)
                else -> Log.d("FEED", "updateFeed: has to be hot or top")
            }
        }
    }
}