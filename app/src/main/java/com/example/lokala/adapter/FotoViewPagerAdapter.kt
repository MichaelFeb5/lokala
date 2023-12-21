package com.example.lokala.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lokala.ui.user.detail_user.FotoUserFragment

class FotoViewPagerAdapter(activity: AppCompatActivity, private val fotolist: List<String>): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return fotolist.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = FotoUserFragment()

        fragment.arguments = Bundle().apply {
            putInt(FotoUserFragment.ARG_POSITION,position)
            putString(FotoUserFragment.ARG_IMAGE,fotolist[position])
        }

        return fragment
    }
}