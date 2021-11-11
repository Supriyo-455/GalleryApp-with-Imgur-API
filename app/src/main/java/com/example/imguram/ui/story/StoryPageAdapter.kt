package com.example.imguram.ui.story

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imguram.R
import com.example.imguram.databinding.ItemStoryBinding
import com.example.libimgur.models.TagResponse

class StoryPageAdapter(

) :
    ListAdapter<TagResponse.Data.Item, StoryPageAdapter.StoryPageViewHolder>(
        StoryDiffUtilItemCallback()
    ) {

    class StoryPageViewHolder(
        val binding: ItemStoryBinding
    ) : RecyclerView.ViewHolder(binding.root)


    class StoryDiffUtilItemCallback : DiffUtil.ItemCallback<TagResponse.Data.Item>() {
        override fun areItemsTheSame(
            oldItem: TagResponse.Data.Item,
            newItem: TagResponse.Data.Item
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TagResponse.Data.Item,
            newItem: TagResponse.Data.Item
        ): Boolean {
            return oldItem.toString().equals(newItem.toString())
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ItemStoryBinding.inflate(inflater, parent, false)
        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
        val image = getItem(position)
        val imgUrl = if (image?.isAlbum == true && image.imagesCount != 0) {
            image.images!![0]?.link
        } else {
            image.link
        }

        imgUrl?.let {
            holder.binding.ivStoryItem.load(imgUrl){
                placeholder(R.drawable.placeholder_image)
                error(R.drawable.placeholer_error_image)
            }
        }
    }
}