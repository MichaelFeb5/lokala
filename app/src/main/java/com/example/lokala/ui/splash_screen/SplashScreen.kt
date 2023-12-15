package com.example.lokala.ui.splash_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.example.lokala.databinding.ActivitySplashScreenBinding
import com.example.lokala.ui.guide.GuideActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handlerSplashScreen(this)

        Glide.with(this)
            .load("https://drive.google.com/file/d/1yBnFTMfHehN6CINsHetwPfZzfT-zWASV/view?usp=sharing")
            .into(binding.splashScreenImage)

    }


    private fun handlerSplashScreen(context: Context) {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(context, GuideActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}