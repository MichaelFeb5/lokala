package com.example.lokala.ui.foto

import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository
import okhttp3.MultipartBody

class FotoViewModel(private val orangHilangRepository: OrangHilangRepository) :
    ViewModel() {
    fun findPeople(
        fotos: MultipartBody.Part,
    ) = orangHilangRepository.findPeople(
        fotos,
    )
}