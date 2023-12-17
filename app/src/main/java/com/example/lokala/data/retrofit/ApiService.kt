package com.dicoding.picodiploma.insagram.data.retrofit

import com.example.lokala.data.response.OrangHilangResponse
import com.example.lokala.data.response.addPeopleResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @GET("getpeople")
    suspend fun getPeople(): OrangHilangResponse

    @Multipart
    @POST("addpeople")
    @Headers("Accept: application/json")
    suspend fun addPeople(
        @Part foto: MultipartBody.Part,
        @Part("nama") nama: RequestBody,
        @Part("umur") umur: RequestBody,
        @Part("tinggi") tinggi: RequestBody,
        @Part("berat_badan") berat_badan: RequestBody,
        @Part("ciri_fisik") ciri_fisik: RequestBody,
        @Part("nomor_dihubungi") nomor_dihubungi: RequestBody,
        @Part("sering_ditemukan_di") sering_ditemukan_di: RequestBody,
        @Part("kota") kota: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("isFound") isFound: RequestBody
    ): addPeopleResponse
}