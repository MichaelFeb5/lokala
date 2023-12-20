package com.example.lokala.ui.guide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lokala.ui.adapter.GuideViewPagerAdapter
import com.example.lokala.databinding.ActivityGuideBinding


class GuideActivity : AppCompatActivity() {


    private lateinit var binding: ActivityGuideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = GuideViewPagerAdapter(this)
        binding.viewPagerGuide.adapter = adapter

    }
}