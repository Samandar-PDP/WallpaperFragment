package com.example.wallpaperapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.ViewPagerAdapter
import com.example.wallpaperapp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment(), TabLayout.OnTabSelectedListener {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.apply {
            addTab(newTab().setText("All"))
            addTab(newTab().setText("New"))
            addTab(newTab().setText("Animals"))
            addTab(newTab().setText("Tech"))
        }
        binding.tabLayout.addOnTabSelectedListener(this)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
                binding.tabLayout.getTabAt(position)?.orCreateBadge?.number
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        binding.viewPager.currentItem = tab?.position!!
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        binding.tabLayout.getTabAt(tab?.position!!)?.removeBadge()
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }
}