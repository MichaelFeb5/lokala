package com.example.lokala.ui.pemerintah.orangHilang.detail

import ResultState
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityDetailOrangHilangBinding
import com.example.lokala.ui.factory.ViewModelFactory
import com.example.lokala.ui.pemerintah.orangHilang.tambah.TambahOrangHilangActivity

class DetailOrangHilangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailOrangHilangBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: DetailOrangHilangViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailOrangHilangBinding.inflate(layoutInflater);
        setContentView(binding.root)
        setViewModelFactory();
        showLoading(false)


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

        binding.btnHapus.setOnClickListener {
            showDeleteConfirmationDialog(orangHilang.id_people)
        }

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, TambahOrangHilangActivity::class.java)
            intent.putExtra("EXTRA_ORANG_HILANG", orangHilang)
            startActivity(intent)
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

    private fun showDeleteConfirmationDialog(id: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Hapus")
        builder.setMessage("Apakah Anda yakin ingin menghapus data ini?")

        builder.setPositiveButton("Ya") { _, _ ->
            deleteOrangHilang(id)
        }

        builder.setNegativeButton("Tidak") { _, _ ->
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun deleteOrangHilang(id: String) {
        viewModel.deleteOrangHilang(id).observe(this) { result ->
            when (result) {
                is ResultState.Loading -> {
                    // Handle loading state if needed
                    showLoading(true)
                }

                is ResultState.Success -> {
                    showLoading(false)
                    showToast(result.data.message)
                    finish() // Finish the activity or navigate to another screen
                }

                is ResultState.Error -> {
                    showLoading(false)
                    showToast("Error: ${result.error}")
                }

                else -> {}
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar2.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun setViewModelFactory() {
        factory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}