package com.example.imguram.ui.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import coil.imageLoader
import coil.request.ImageRequest
import coil.size.ViewSizeResolver
import com.example.imguram.R
import com.example.imguram.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    private val viewModel by viewModels<StoryViewModel>()
    private var adapter = StoryPageAdapter()
    private lateinit var binding: ActivityStoryBinding
    private val pageChangeCallback = StoryPageChangeCallback()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val tagName = intent.getStringExtra("tag")

        tagName?.let {
            viewModel.fetchTag(tagName)
        }
        binding.storyImageView.adapter = adapter
        binding.storyImageView.registerOnPageChangeCallback(pageChangeCallback)
    }

    private val nextPageRunnable = Runnable {
        binding.storyImageView.currentItem++
    }

    inner class StoryPageChangeCallback : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.statusProgress.scaleX = 0F
            binding.statusProgress.animate()
                .scaleX(1F)
                .setDuration(5000)
                .start()

            handler.removeCallbacks(nextPageRunnable)
            handler.postDelayed(nextPageRunnable, 5000)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.images.observe(this) {
            adapter.submitList(it)
        }
    }
}