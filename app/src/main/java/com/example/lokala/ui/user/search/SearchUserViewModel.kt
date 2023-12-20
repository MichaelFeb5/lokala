package com.example.lokala.ui.user.search

import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository

class SearchUserViewModel(private val orangHilangRepository: OrangHilangRepository) : ViewModel() {
    fun getOrangHilangByName(nama: String, kota : String, gender : String) = orangHilangRepository.getOrangHilangByName(nama,kota,gender)
}