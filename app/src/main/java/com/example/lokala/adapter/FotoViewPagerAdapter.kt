package com.example.lokala.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lokala.ui.user.detail_user.FotoUserFragment

class FotoViewPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = FotoUserFragment()

        fragment.arguments = Bundle().apply {
            putInt(FotoUserFragment.ARG_POSITION,position)
        }

        return fragment
    }
}