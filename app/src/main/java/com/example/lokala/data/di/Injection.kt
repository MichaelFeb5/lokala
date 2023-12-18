package com.example.lokala.data.di

import android.content.Context
import com.dicoding.picodiploma.insagram.data.retrofit.ApiConfig
import com.example.lokala.data.repository.OrangHilangRepository

object Injection {
    fun provideOrangHilangRepository(context: Context): OrangHilangRepository {
        val apiService = ApiConfig.getApiService()
        return OrangHilangRepository.getInstance(apiService)
    }
}