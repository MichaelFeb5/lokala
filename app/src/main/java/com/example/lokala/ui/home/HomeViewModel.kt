package com.example.lokala.ui.home

import ResultState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository
import com.example.lokala.data.response.OrangHilangResponse

class HomeViewModel(private val orangHilangRepository: OrangHilangRepository) : ViewModel() {


    fun getOrangHilang(): LiveData<ResultState<OrangHilangResponse>> = orangHilangRepository.getOrangHilang()
}