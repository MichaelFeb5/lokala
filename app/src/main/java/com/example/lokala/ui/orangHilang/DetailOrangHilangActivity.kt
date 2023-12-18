package com.example.lokala.ui.orangHilang

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityDetailOrangHilangBinding
import com.example.lokala.ui.factory.ViewModelFactory

class DetailOrangHilangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailOrangHilangBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: DetailOrangHilangViewModel by viewModels { factory }

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
//
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

        binding.apply {
            tvNama.text = orangHilang.nama
            tvStatus.text = status
            tvGenderBeratUmur.text =
                "${orangHilang.gender}, ${orangHilang.beratBadan} Kg, ${orangHilang.umur} Tahun"
            tvSeringDitemukan.text = orangHilang.seringDitemukanDi
            etLokasi.setText(orangHilang.kota);
            tvCiriFisik.text = orangHilang.ciriFisik;
        }
    }
}