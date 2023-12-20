package com.example.lokala.ui.user.detail

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.lokala.R
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityDetailOrangHilangBinding
import com.example.lokala.ui.factory.ViewModelFactory
import com.example.lokala.ui.pemerintah.orangHilang.detail.DetailOrangHilangViewModel
import com.example.lokala.ui.pemerintah.orangHilang.tambah.TambahOrangHilangActivity

class UserDetailOrangHilangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailOrangHilangBinding
    private lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailOrangHilangBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val orangHilang = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("EXTRA_ORANG_HILANG", OrangHilangItem::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EXTRA_ORANG_HILANG")
        }

        if (orangHilang != null) {
            setupView(orangHilang)
        }

    }

    private fun setupView(orangHilang: OrangHilangItem) {
        Glide.with(this).load(orangHilang.urlFoto[0]).into(binding.ivOrangHilang)

        var status = if (orangHilang.isFound) {
            "Ditemukan"
        } else {
            "Hilang"
        }
    }
}