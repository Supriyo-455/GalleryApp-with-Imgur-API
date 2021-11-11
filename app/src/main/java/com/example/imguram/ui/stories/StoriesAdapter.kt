package com.example.imguram.ui.stories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imguram.databinding.ListItemStoryBinding
import com.example.libimgur.models.GalleryTagsResponse

class StoriesAdapter :
    ListAdapter<GalleryTagsResponse.Data.Tag, StoriesAdapter.StoriesViewHolder>
        (StoriesDiffCallBack()) {

    class StoriesViewHolder(
        val binding: ListItemStoryBinding
    ) : RecyclerView.ViewHolder(
        binding.root
    )

    private class StoriesDiffCallBack : DiffUtil.ItemCallback<GalleryTagsResponse.Data.Tag>() {
        override fun areItemsTheSame(
            oldItem: GalleryTagsResponse.Data.Tag,
            newItem: GalleryTagsResponse.Data.Tag
        ) = (oldItem == newItem)

        override fun areContentsTheSame(
            oldItem: GalleryTagsResponse.Data.Tag,
            newItem: GalleryTagsResponse.Data.Tag
        ) = (oldItem.toString().equals(newItem.toString()))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryBinding.inflate(inflater, parent, false)

        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tags = getItem(position)
        holder.binding.tvStoryHead.text = tags.name
        holder.binding.ivStoryHead.load(
            "https://i.imgur.com/${tags.backgroundHash}.jpg"
        )
    }
}