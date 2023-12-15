package com.example.lokala.ui.orangHilang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lokala.R
import com.example.lokala.databinding.ActivityTambahOrangHilangBinding
class TambahOrangHilangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahOrangHilangBinding
    // Initialize variables

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahOrangHilangBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }
}