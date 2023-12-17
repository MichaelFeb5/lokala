package com.example.lokala.ui.orangHilang

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

    private fun showImage() {
        currentImageUri?.let {
            binding.ivFoto.setPadding(0, 0, 0, 0)
            binding.ivFoto.setImageURI(it)
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

            val nama = binding.etNama.text.toString()
            val umur = binding.etUmur.text.toString().toInt()
            val nomorPemerintah = binding.etNomorPemerintah.text.toString()
            val tempatSeringTerlihat = binding.etTempatSeringTerlihat.text.toString()
            val terakhirTerlihat = binding.etTerakhirTerlihat.text.toString()
            val ciriFisik = binding.etCiriFisik.text.toString()
            val gender =
                if (binding.genderRadioGroup.checkedRadioButtonId == R.id.genderL) "Laki-Laki" else "Perempuan"
            val isFound = binding.statusRadioGroup.checkedRadioButtonId == R.id.status_ditemukan

            // Do something with the collected data, for example, pass it to the ViewModel
            viewModel.addPeople(
                multipartBody,
                nama,
                umur,
                170,
                80,
                ciriFisik,
                nomorPemerintah,
                tempatSeringTerlihat,
                "banjarbaru",
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
