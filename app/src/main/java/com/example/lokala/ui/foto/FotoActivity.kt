package com.example.lokala.ui.foto

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.dicoding.picodiploma.storify.data.utils.getImageUri
import com.example.lokala.R
import com.example.lokala.databinding.ActivityFotoBinding

class FotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFotoBinding
    private var currentImageUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnCamera.setOnClickListener {
                currentImageUri = getImageUri(this@FotoActivity)
                launcherIntentCamera.launch(currentImageUri)
            }

            btnGalery.setOnClickListener {
                launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }

            btnSearchFoto.setOnClickListener {

            }
        }
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
        }
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
        }else{
            showToast(this@FotoActivity, "No Photo Captured")
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            binding.ivFotoCari.setPadding(0, 0, 0, 0)
            binding.ivFotoCari.setImageURI(it)
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}