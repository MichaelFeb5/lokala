package com.example.lokala.adapter


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lokala.ui.guide.FragmentChoiceUser
import com.example.lokala.ui.guide.GuideFragment

class GuideViewPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragmentGuide = GuideFragment()
        val fragmentChoiceUser = FragmentChoiceUser()

        when(position) {
            0 ->  {
                fragmentGuide.arguments = Bundle().apply {
                    putInt(GuideFragment.ARG_POSITION, 0)
                }
                return fragmentGuide
            }
            1 -> {
                fragmentGuide.arguments = Bundle().apply {
                    putInt(GuideFragment.ARG_POSITION,1)
                }
                return fragmentGuide
            }
            else -> return fragmentChoiceUser

        }


    }
}