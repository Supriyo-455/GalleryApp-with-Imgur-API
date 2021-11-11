package com.example.imguram.ui.home


import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import com.example.imguram.R
import com.example.imguram.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesAdapter = StoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStories.apply {
            layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.HORIZONTAL,
                    false
                )
            adapter = storiesAdapter
        }

        setUpNav()

        storiesViewModel.fetchTags()
    }

    private fun setUpNav() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_hot,
//                R.id.navigation_top
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.tags.observe(this) {
            it.forEach{ tag ->
                val request = ImageRequest.Builder(this)
                    .data("https://i.imgur.com/${tag?.backgroundHash}.jpg")
                    .size(resources.getDimensionPixelSize(R.dimen.story_icon_size))
                    .build()
                imageLoader.enqueue(request)
            }
            storiesAdapter.submitList(it)
        }
    }
}