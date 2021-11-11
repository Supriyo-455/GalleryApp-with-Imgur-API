package com.example.imguram.ui.feed


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.imageLoader
import coil.request.ImageRequest
import com.example.imguram.R
import com.example.imguram.databinding.FeedFragmentBinding

class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()
    private val feedRecyclerAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed") //TODO: turn it into enum

        feed?.let {
            viewModel.updateFeed(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FeedFragmentBinding.inflate(inflater, container, false)
        binding.rvGalleryFeed.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGalleryFeed.adapter = feedRecyclerAdapter

        viewModel.feed.observe(viewLifecycleOwner) {
            feedRecyclerAdapter.submitList(it)
            Toast.makeText(
                requireContext(), "Download ${it?.let { it.size } ?: 0} images", Toast
                    .LENGTH_SHORT
            )
                .show()
        }
        return binding.root
    }
}