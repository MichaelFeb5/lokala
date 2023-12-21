package com.example.lokala.adapter


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lokala.ui.user.home_fragment.BannerFragment

class BannerViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
       val fragment = BannerFragment()

        fragment.arguments = Bundle().apply {
            putInt(BannerFragment.ARG_POSITION, position)
        }
        return fragment

    }
}