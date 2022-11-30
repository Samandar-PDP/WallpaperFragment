package com.example.wallpaperapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.ImageAdapter
import com.example.wallpaperapp.util.Constants

class AllFragment : Fragment() {
    private val imageAdapter by lazy{ImageAdapter()}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv: RecyclerView = view.findViewById(R.id.rv)
        rv.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = imageAdapter
        }
        imageAdapter.submitList(Constants.imageList())
        imageAdapter.onClick = {
            val bundle = bundleOf("image" to it)
            findNavController().navigate(R.id.action_mainFragment_to_imageFragment, bundle)
        }
    }
}