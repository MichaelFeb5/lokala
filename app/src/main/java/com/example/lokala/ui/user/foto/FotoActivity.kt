package com.example.lokala.ui.user.foto


import android.app.ProgressDialog
import android.content.Intent
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.dicoding.picodiploma.storify.data.utils.getImageUri
import com.dicoding.picodiploma.storify.data.utils.reduceFileImage
import com.dicoding.picodiploma.storify.data.utils.uriToFile
import com.example.lokala.ui.fragment_utils.LoadingDialogFragment
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityFotoBinding
import com.example.lokala.ui.factory.ViewModelFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody

@Suppress("DEPRECATION")
class FotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFotoBinding
    private var currentImageUri: Uri? = null
    private lateinit var factory: ViewModelFactory
    private val viewModel: FotoViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewModelFactory()
        val loadingDialog = LoadingDialogFragment()


        with(binding) {

            btnCamera.setOnClickListener {
                currentImageUri = getImageUri(this@FotoActivity)
                launcherIntentCamera.launch(currentImageUri)
            }

            btnBack.setOnClickListener {
                onBackPressed();
            }

            btnGalery.setOnClickListener {
                launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }

            btnSearchFoto.setOnClickListener {
                if(currentImageUri != null) {
                    val imageFile = uriToFile(currentImageUri!!, baseContext).reduceFileImage()
                    val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
                    val multipartBody = MultipartBody.Part.createFormData(
                        "uploaded_img", imageFile.name, requestImageFile
                    )

                    viewModel.findPeople(multipartBody).observe(this@FotoActivity) { result ->
                        when (result) {
                            is ResultState.Loading -> {
                                loadingDialog.show(supportFragmentManager, "loadingDialog")
                            }

                            is ResultState.Success -> {
                                loadingDialog.dismiss()
                                val intent = Intent(this@FotoActivity, ResultFotoActivity::class.java)
                                intent.putExtra("IMAGE_URI", currentImageUri.toString())

                                // Fetch Result then convert into array
                                val array = arrayListOf<OrangHilangItem>()
                                result.data.data.map {
                                    Log.d("Hasil" , it.toString())
                                    array.add(it)
                                }

                                intent.putParcelableArrayListExtra("LIST_HASIL_ORANG_HILANG", ArrayList(array))
                                startActivity(intent)
                            }

                            is ResultState.Error -> {
                                showToast(baseContext,"Server Error")
                            }

                            else -> {
                            }
                        }
                    }

                } else {
                    showToast(this@FotoActivity, "Silahkan Upload Foto Terlebih Dahulu")
                }
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

    private fun setViewModelFactory() {
        factory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}