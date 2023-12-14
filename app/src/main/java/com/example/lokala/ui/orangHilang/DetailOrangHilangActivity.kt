package com.example.lokala.ui.orangHilang

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lokala.data.dummy.OrangHilang
import com.example.lokala.databinding.ActivityDetailOrangHilangBinding

class DetailOrangHilangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailOrangHilangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailOrangHilangBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val orangHilang = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("EXTRA_ORANG_HILANG", OrangHilang::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EXTRA_ORANG_HILANG")
        }

        if (orangHilang != null) {
            setupView(orangHilang)
        }
    }

    private fun setupView(orangHilang: OrangHilang) {
        Glide.with(this).load(orangHilang.url_foto[0]).into(binding.ivOrangHilang)

        var status = if (orangHilang.isFound) {
            "Ditemukan"
        } else {
            "Hilang"
        }

        binding.apply {
            tvNama.text = orangHilang.nama
            tvStatus.text = status
            tvGenderBeratUmur.text =
                "${orangHilang.gender}, ${orangHilang.berat_badan} Kg, ${orangHilang.umur} Tahun"
            tvSeringDitemukan.text = orangHilang.sering_ditemukan_di
//            edLokasi2.setText(orangHilang.sering_ditemukan_di);
            tvCiriFisik.text = orangHilang.ciri_fisik;
        }
    }
}