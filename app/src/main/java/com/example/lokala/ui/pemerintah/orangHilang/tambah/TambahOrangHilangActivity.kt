package com.example.lokala.ui.pemerintah.orangHilang.tambah

import ResultState
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.storify.data.utils.reduceFileImage
import com.dicoding.picodiploma.storify.data.utils.uriToFile
import com.example.lokala.R
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityTambahOrangHilangBinding
import com.example.lokala.ui.factory.ViewModelFactory
import com.example.lokala.ui.pemerintah.home.MainActivity
import com.example.lokala.ui.user.UserActivity
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody

class TambahOrangHilangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahOrangHilangBinding
    private var currentImageUri: Uri? = null
    private var currentImageUri2: Uri? = null
    private lateinit var factory: ViewModelFactory
    private val viewModel: TambahOrangHilangViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahOrangHilangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewModelFactory();

        val orangHilang = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("EXTRA_ORANG_HILANG", OrangHilangItem::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("EXTRA_ORANG_HILANG")
        }

        if (orangHilang != null) {
            setData(orangHilang)
        }

        setupAction(orangHilang)
    }

    private fun setData(item: OrangHilangItem) {
        binding.etNama.setText(item.nama)
        binding.etUmur.setText(item.umur.toString())
        binding.etNomorPemerintah.setText(item.nomorDihubungi)
        binding.etTempatSeringTerlihat.setText(item.seringDitemukanDi)
        binding.etKota.setText(item.kota)
        binding.etCiriFisik.setText(item.ciriFisik)
        binding.etTinggiBadan.setText(item.tinggi.toString())
        binding.etBeratBadan.setText(item.beratBadan.toString())

        if (item.gender == "Laki-laki") {
            binding.genderRadioGroup.check(R.id.genderL)
        } else {
            binding.genderRadioGroup.check(R.id.genderP)
        }

        if (item.isFound) {
            binding.statusRadioGroup.check(R.id.status_ditemukan)
        } else {
            binding.statusRadioGroup.check(R.id.status_hilang)
        }

        Glide.with(this).load(item.urlFoto[0]).into(binding.ivFoto)
        Glide.with(this).load(item.urlFoto[1]).into(binding.ivFoto2)
    }

    private fun setupAction(orangHilangItem: OrangHilangItem?) {
        // Galeri
        binding.btnCamera.setOnClickListener {
            launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.btnCamera2.setOnClickListener {
            launcherGallery2.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        // Submit
        binding.btnSubmit.setOnClickListener {
            if (orangHilangItem != null)
            handleSubmitButtonClick(orangHilangItem.id_people)
            else handleSubmitButtonClick(null)
        }
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            // Handle case when no image is selected
        }
    }

    private val launcherGallery2 = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri2 = uri
            showImage2()
        } else {
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            binding.ivFoto.setPadding(0, 0, 0, 0)
            binding.ivFoto.setImageURI(it)
        }
    }

    private fun showImage2() {
        currentImageUri2?.let {
            binding.ivFoto2.setPadding(0, 0, 0, 0)
            binding.ivFoto2.setImageURI(it)
        }
    }

    private fun handleSubmitButtonClick(id: String?) {
        if (currentImageUri != null && currentImageUri2 != null) {
            // Adding Foto
            val imageFile = uriToFile(currentImageUri!!, this).reduceFileImage()
            val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
            val multipartBody = MultipartBody.Part.createFormData(
                "fotos[]", imageFile.name, requestImageFile
            )

            val imageFile2 = uriToFile(currentImageUri2!!, this).reduceFileImage()
            val requestImageFile2 = imageFile2.asRequestBody("image/jpeg".toMediaType())
            val multipartBody2 = MultipartBody.Part.createFormData(
                "fotos[]", imageFile2.name, requestImageFile2
            )

            val nama = binding.etNama.text.toString()
            val umur = binding.etUmur.text.toString().toInt()
            val nomorPemerintah = binding.etNomorPemerintah.text.toString()
            val tempatSeringTerlihat = binding.etTempatSeringTerlihat.text.toString()
            val kota = binding.etKota.text.toString()
            val ciriFisik = binding.etCiriFisik.text.toString()
            val tinggiBadan = binding.etTinggiBadan.text.toString().toInt()
            val beratBadan = binding.etBeratBadan.text.toString().toInt()
            val gender =
                if (binding.genderRadioGroup.checkedRadioButtonId == R.id.genderL) "Laki-Laki" else "Perempuan"
            val isFound = binding.statusRadioGroup.checkedRadioButtonId == R.id.status_ditemukan

            if (id == null) {
                viewModel.addPeople(
                    multipartBody,
                    multipartBody2,
                    nama,
                    umur,
                    tinggiBadan,
                    beratBadan,
                    ciriFisik,
                    nomorPemerintah,
                    tempatSeringTerlihat,
                    kota,
                    gender,
                    isFound
                ).observe(this@TambahOrangHilangActivity) { result ->
                    when (result) {
                        is ResultState.Loading -> {
//                        showLoading(true)
                        }

                        is ResultState.Success -> {
//                        showLoading(false)
                            finish()
                        }

                        is ResultState.Error -> {
//                        showLoading(false)
                            showToast("Server Error")
                        }

                        else -> {
                            // Handle other states if needed
                        }
                    }
                }
            }

            viewModel.editPeople(
                id!!,
                multipartBody,
                multipartBody2,
                nama,
                umur,
                tinggiBadan,
                beratBadan,
                ciriFisik,
                nomorPemerintah,
                tempatSeringTerlihat,
                kota,
                gender,
                isFound
            ).observe(this@TambahOrangHilangActivity) { result ->
                when (result) {
                    is ResultState.Loading -> {
//                        showLoading(true)
                    }

                    is ResultState.Success -> {
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                    is ResultState.Error -> {
//                        showLoading(false)
                        showToast("Server Error")
                    }

                    else -> {
                        // Handle other states if needed
                    }
                }
            }
        } else {
            showToast("Silahkan Sisipkan Image Lagi")
        }


    }

    private fun setViewModelFactory() {
        factory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
