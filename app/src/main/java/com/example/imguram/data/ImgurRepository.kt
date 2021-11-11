package com.example.imguram.data

import com.example.libimgur.ImgurClient
import com.example.libimgur.models.GalleryResponse
import com.example.libimgur.models.GalleryTagsResponse
import com.example.libimgur.params.Section

class ImgurRepository {
    val api = ImgurClient.api

    suspend fun getHotFeed(): List<GalleryResponse.Data?>? {//TODO: replace with proper error object
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<GalleryResponse.Data?>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }

    suspend fun getTags(): List<GalleryTagsResponse.Data.Tag>? {
        val response = api.getTags()
        return response.body()?.data?.tags
    }
}