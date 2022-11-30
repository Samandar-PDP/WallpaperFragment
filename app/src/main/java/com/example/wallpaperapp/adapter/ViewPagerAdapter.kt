package com.example.wallpaperapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wallpaperapp.fragments.AllFragment
import com.example.wallpaperapp.fragments.AnimalsFragment
import com.example.wallpaperapp.fragments.NewFragment
import com.example.wallpaperapp.fragments.TechnologyFragment

class ViewPagerAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllFragment()
            1 -> NewFragment()
            2 -> AnimalsFragment()
            3 -> TechnologyFragment()
            else -> Fragment()
        }
    }
}