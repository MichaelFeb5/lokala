package com.example.lokala.data.repository

import ResultState
import android.util.Log
import androidx.lifecycle.liveData
import com.dicoding.picodiploma.insagram.data.retrofit.ApiService
import com.example.lokala.data.response.OrangHilangResponse
import com.example.lokala.data.response.addPeopleResponse
import com.example.lokala.data.response.deleteResponse
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException

class OrangHilangRepository(
    private val apiService: ApiService
) {

    fun getOrangHilang() = liveData {
        emit(ResultState.Loading)
        try {
            val orangHilang = apiService.getPeople()
            Log.d("API_RESPONSE", Gson().toJson(orangHilang.data.toString()))
            emit(ResultState.Success(orangHilang))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, OrangHilangResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }

    fun findPeople(fotos: MultipartBody.Part,) = liveData {
        emit(ResultState.Loading)
        try {
            val orangHilang = apiService.findPeople(fotos)
            Log.d("API_RESPONSE", Gson().toJson(orangHilang.data.toString()))
            emit(ResultState.Success(orangHilang))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, OrangHilangResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }

    fun getOrangHilangByName(nama : String, kota : String, gender : String) = liveData {
        emit(ResultState.Loading)
        try {
            val orangHilang = apiService.getPeopleByName(nama,kota,gender)
            Log.d("API_RESPONSE", Gson().toJson(orangHilang.data.toString()))
            emit(ResultState.Success(orangHilang))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, OrangHilangResponse::class.java)
            emit(ResultState.Error(errorResponse.status))
        }
    }

    fun deteleOrangHilang(id : String) = liveData {
        emit(ResultState.Loading)
        try {
            Log.d("id", id)
            val response = apiService.deletePeople(id)
            Log.d("API_RESPONSE2", Gson().toJson(response.toString()))
            emit(ResultState.Success(response))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, deleteResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }

    fun addPeople(
        fotos: MultipartBody.Part,
        fotos2: MultipartBody.Part,
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
    ) =
        liveData {
            val namaRequestBody = nama.toRequestBody("text/plain".toMediaTypeOrNull())
            val umurRequestBody = umur.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val tinggiRequestBody =
                tinggi.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val beratBadanRequestBody =
                berat_badan.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val ciriFisikRequestBody = ciri_fisik.toRequestBody("text/plain".toMediaTypeOrNull())
            val nomorDihubungiRequestBody =
                nomor_dihubungi.toRequestBody("text/plain".toMediaTypeOrNull())
            val seringDitemukanDiRequestBody =
                sering_ditemukan_di.toRequestBody("text/plain".toMediaTypeOrNull())
            val kotaRequestBody = kota.toRequestBody("text/plain".toMediaTypeOrNull())
            val genderRequestBody = gender.toRequestBody("text/plain".toMediaTypeOrNull())
            val isFoundRequestBody =
                isFound.toString().toRequestBody("text/plain".toMediaTypeOrNull())

            emit(ResultState.Loading)
            try {
                val successResponse = apiService.addPeople(
                    fotos,
                    fotos2,
                    namaRequestBody,
                    umurRequestBody,
                    tinggiRequestBody,
                    beratBadanRequestBody,
                    ciriFisikRequestBody,
                    nomorDihubungiRequestBody,
                    seringDitemukanDiRequestBody,
                    kotaRequestBody,
                    genderRequestBody,
                    isFoundRequestBody
                )
                emit(ResultState.Success(successResponse))
            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, addPeopleResponse::class.java)
                emit(ResultState.Error(errorResponse.message))
            }
        }

    fun editPeople(
        id: String,
        fotos: MultipartBody.Part,
        fotos2: MultipartBody.Part,
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
    ) =
        liveData {
            val namaRequestBody = nama.toRequestBody("text/plain".toMediaTypeOrNull())
            val umurRequestBody = umur.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val tinggiRequestBody =
                tinggi.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val beratBadanRequestBody =
                berat_badan.toString().toRequestBody("text/plain".toMediaTypeOrNull())
            val ciriFisikRequestBody = ciri_fisik.toRequestBody("text/plain".toMediaTypeOrNull())
            val nomorDihubungiRequestBody =
                nomor_dihubungi.toRequestBody("text/plain".toMediaTypeOrNull())
            val seringDitemukanDiRequestBody =
                sering_ditemukan_di.toRequestBody("text/plain".toMediaTypeOrNull())
            val kotaRequestBody = kota.toRequestBody("text/plain".toMediaTypeOrNull())
            val genderRequestBody = gender.toRequestBody("text/plain".toMediaTypeOrNull())
            val isFoundRequestBody =
                isFound.toString().toRequestBody("text/plain".toMediaTypeOrNull())

            emit(ResultState.Loading)
            try {
                val successResponse = apiService.editPeople(
                    id,
                    fotos,
                    fotos2,
                    namaRequestBody,
                    umurRequestBody,
                    tinggiRequestBody,
                    beratBadanRequestBody,
                    ciriFisikRequestBody,
                    nomorDihubungiRequestBody,
                    seringDitemukanDiRequestBody,
                    kotaRequestBody,
                    genderRequestBody,
                    isFoundRequestBody
                )
                emit(ResultState.Success(successResponse))
            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(errorBody, addPeopleResponse::class.java)
                emit(ResultState.Error(errorResponse.message))
            }
        }


    companion object {
        @Volatile
        private var instance: OrangHilangRepository? = null
        fun getInstance(
            apiService: ApiService
        ): OrangHilangRepository = instance ?: synchronized(this) {
            instance ?: OrangHilangRepository(apiService)
        }.also { instance = it }
    }
}