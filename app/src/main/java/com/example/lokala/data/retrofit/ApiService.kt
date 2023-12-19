package com.dicoding.picodiploma.insagram.data.retrofit

import com.example.lokala.data.response.OrangHilangResponse
import com.example.lokala.data.response.addPeopleResponse
import com.example.lokala.data.response.deleteResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("getpeople")
    suspend fun getPeople(): OrangHilangResponse

    @GET("getpeople")
    suspend fun getPeopleById(
        @Query("id_people") id: String
    ): OrangHilangResponse

    @GET("getpeople")
    suspend fun getPeopleByName(
        @Query("nama") nama: String
    ): OrangHilangResponse

    @Multipart
    @POST("findpeople")
    @Headers("Accept: application/json")
    suspend fun findPeople(
        @Part foto: MultipartBody.Part,
    ): OrangHilangResponse

    @Multipart
    @POST("addpeople")
    @Headers("Accept: application/json")
    suspend fun addPeople(
        @Part foto: MultipartBody.Part,
        @Part foto2: MultipartBody.Part,
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

    @Multipart
    @PUT("editpeople/{id}")
    @Headers("Accept: application/json")
    suspend fun editPeople(
        @Path("id") id: String,
        @Part foto: MultipartBody.Part,
        @Part foto2: MultipartBody.Part,
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

    @DELETE("deletepeople/{id}")
    suspend fun deletePeople(@Path("id") id: String): deleteResponse
}