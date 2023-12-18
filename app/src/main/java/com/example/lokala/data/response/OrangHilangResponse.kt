package com.example.lokala.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class OrangHilangResponse(
    @SerializedName("data")
    val data: List<OrangHilangItem>,

    @SerializedName("message")
    val message: String,

    @SerializedName("status")
    val status: String
)

@Parcelize
data class OrangHilangItem(
    @SerializedName("id_people")
    val id_people: String,

    @SerializedName("berat_badan")
    val beratBadan: Int, // It could be Int or String based on the JSON

    @SerializedName("ciri_fisik")
    val ciriFisik: String,

    @SerializedName("foto")
    val foto: List<String>,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("isFound")
    val isFound: Boolean, // It could be Boolean or String based on the JSON

    @SerializedName("kota")
    val kota: String,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("nomor_dihubungi")
    val nomorDihubungi: String, // It could be Int or String based on the JSON

    @SerializedName("sering_ditemukan_di")
    val seringDitemukanDi: String,

    @SerializedName("tinggi")
    val tinggi: Int, // It could be Int or String based on the JSON

    @SerializedName("umur")
    val umur: Int, // It could be Int or String based on the JSON

    @SerializedName("url_foto")
    val urlFoto: List<String> // It could be String or List<String> based on the JSON
): Parcelable


data class addPeopleResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("status")
    val status: String
)

data class deleteResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("status")
    val status: String
)