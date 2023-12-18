package com.example.lokala.ui.home

import ResultState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository
import com.example.lokala.data.response.OrangHilangResponse

class HomeViewModel(private val orangHilangRepository: OrangHilangRepository) : ViewModel() {

    private val _orangHilangLiveData = MutableLiveData<ResultState<OrangHilangResponse>>()
    val orangHilangLiveData: LiveData<ResultState<OrangHilangResponse>> get() = _orangHilangLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getOrangHilang(): LiveData<ResultState<OrangHilangResponse>> = orangHilangRepository.getOrangHilang()

}