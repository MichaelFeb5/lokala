package com.example.lokala.ui.pemerintah.orangHilang.tambah

import ResultState
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.storify.data.utils.reduceFileImage
import com.dicoding.picodiploma.storify.data.utils.uriToFile
import com.example.lokala.R
import com.example.lokala.databinding.ActivityTambahOrangHilangBinding
import com.example.lokala.ui.factory.ViewModelFactory
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

        setupAction()
    }

    private fun setupAction() {
        // Galeri
        binding.btnCamera.setOnClickListener {
            launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.btnCamera2.setOnClickListener {
            launcherGallery2.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        // Submit
        binding.btnSubmit.setOnClickListener {
            handleSubmitButtonClick()
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

    private fun handleSubmitButtonClick() {
        currentImageUri?.let { uri ->
            // Adding Foto
            val imageFile = uriToFile(uri, this).reduceFileImage()
            val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
            val multipartBody = MultipartBody.Part.createFormData(
                "fotos[]", imageFile.name, requestImageFile
            )

            val imageFile2 = uriToFile(uri, this).reduceFileImage()
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

            // Do something with the collected data, for example, pass it to the ViewModel
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


    }

    private fun setViewModelFactory() {
        factory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
