package com.example.lokala.ui.orangHilang

import ResultState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository
import com.example.lokala.data.response.OrangHilangResponse

class DetailOrangHilangViewModel(private val orangHilangRepository: OrangHilangRepository) : ViewModel() {

    fun getOrangHilangById(id: String): LiveData<ResultState<OrangHilangResponse>> = orangHilangRepository.getOrangHilangById(id)

}