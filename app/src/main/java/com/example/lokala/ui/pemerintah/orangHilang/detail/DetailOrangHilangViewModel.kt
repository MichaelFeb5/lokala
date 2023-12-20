package com.example.lokala.ui.pemerintah.orangHilang.detail

import ResultState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository
import com.example.lokala.data.response.deleteResponse

class DetailOrangHilangViewModel(private val orangHilangRepository: OrangHilangRepository) : ViewModel() {

    fun deleteOrangHilang(id: String): LiveData<ResultState<deleteResponse>> = orangHilangRepository.deteleOrangHilang(id)

}