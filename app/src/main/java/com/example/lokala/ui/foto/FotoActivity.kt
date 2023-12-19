package com.example.lokala.ui.foto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lokala.R
import com.example.lokala.databinding.ActivityFotoBinding

class FotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}