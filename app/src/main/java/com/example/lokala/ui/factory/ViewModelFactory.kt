package com.example.lokala.ui.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lokala.data.di.Injection
import com.example.lokala.data.repository.OrangHilangRepository
import com.example.lokala.ui.home.HomeViewModel
import com.example.lokala.ui.orangHilang.DetailOrangHilangViewModel
import com.example.lokala.ui.orangHilang.TambahOrangHilangViewModel

class ViewModelFactory(
    private val orangHilangRepository: OrangHilangRepository

) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(orangHilangRepository) as T
        }
        if (modelClass.isAssignableFrom(TambahOrangHilangViewModel::class.java)) {
            return TambahOrangHilangViewModel(orangHilangRepository) as T
        }
        if (modelClass.isAssignableFrom(DetailOrangHilangViewModel::class.java)) {
            return DetailOrangHilangViewModel(orangHilangRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }


    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(
                Injection.provideOrangHilangRepository(context)
            )
        }.also { instance = it }
    }
}