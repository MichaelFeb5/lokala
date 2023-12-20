package com.example.lokala.ui.user.foto

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityResultFotoBinding
import com.example.lokala.ui.adapter.OrangHilangAdapter
import com.example.lokala.ui.adapter.UserOrangHilangAdapter
import com.example.lokala.ui.pemerintah.orangHilang.detail.DetailOrangHilangActivity
import com.example.lokala.ui.user.detail.UserDetailOrangHilangActivity

class ResultFotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultFotoBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataKosong(false)

        // Get Data
        val imageUriString = intent.getStringExtra("IMAGE_URI")
        val listOrangHilang =
            intent.getParcelableArrayListExtra<OrangHilangItem>("LIST_HASIL_ORANG_HILANG")

        // Set gambar
        showPhotoFind(imageUriString!!)

        // Attach data to recycle view
        if (listOrangHilang != null) {
            showRvList(listOrangHilang)
            binding.tvPeopleHasil.setText("People Found : ${listOrangHilang.size}")
        } else {
            showDataKosong(true)
            binding.tvPeopleHasil.setText("People Found : 0")
        }

        // Btn Back
        binding.btnKembali.setOnClickListener {
            finish();
        }
    }

    private fun showRvList(list: List<OrangHilangItem>) {
        with(binding) {
            val orangHilangAdapter = OrangHilangAdapter(baseContext, list)
            rvResultUserOrangHilang.adapter = orangHilangAdapter

            binding.rvResultUserOrangHilang.apply {
                layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                adapter = orangHilangAdapter
            }

            orangHilangAdapter.setOnItemClickListener(object : OrangHilangAdapter.OnItemClickListener {
                override fun onClick(ivOrangHilang: ImageView, orangHilangItem: OrangHilangItem) {
                    val intent = Intent(baseContext, UserDetailOrangHilangActivity::class.java)
                    intent.putExtra("EXTRA_ORANG_HILANG", orangHilangItem)
                    startActivity(intent)
                }
            })
        }
    }

    private fun showDataKosong(isLoading: Boolean) {
        binding.tvResultDataTidakDitemukan.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showPhotoFind(imageUriString : String){
        val imageUri = Uri.parse(imageUriString)
        binding.imExampleFotoHasil.setImageURI(imageUri)
    }
}