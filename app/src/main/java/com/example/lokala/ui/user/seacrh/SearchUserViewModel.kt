package com.example.lokala.ui.user.seacrh

import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository

class SearchUserViewModel(private val orangHilangRepository: OrangHilangRepository) : ViewModel() {
    fun getOrangHilangByName(nama: String) = orangHilangRepository.getOrangHilangByName(nama)
}