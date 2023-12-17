package com.example.lokala.ui.orangHilang

import androidx.lifecycle.ViewModel
import com.example.lokala.data.repository.OrangHilangRepository
import okhttp3.MultipartBody

class TambahOrangHilangViewModel(private val orangHilangRepository: OrangHilangRepository) :
    ViewModel() {
    fun addPeople(
        fotos: MultipartBody.Part,
        nama: String,
        umur: Int,
        tinggi: Int,
        berat_badan: Int,
        ciri_fisik: String,
        nomor_dihubungi: String,
        sering_ditemukan_di: String,
        kota: String,
        gender: String,
        isFound: Boolean
    ) = orangHilangRepository.addPeople(
        fotos,
        nama,
        umur,
        tinggi,
        berat_badan,
        ciri_fisik,
        nomor_dihubungi,
        sering_ditemukan_di,
        kota,
        gender,
        isFound
    )
}