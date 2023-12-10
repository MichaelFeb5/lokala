package com.example.lokala.data.dummy

data class OrangHilangDummy(
    val error: Boolean,
    val message:String,
    val data: List<OrangHilang>
)

data class OrangHilang(
    val berat_badan: String,
    val ciri_fisik: String,
    val foto: List<String>,
    val gender: String,
    val isFound: Boolean,
    val kota: String,
    val nama: String,
    val nomor_dihubungi: String,
    val sering_ditemukan_di: String,
    val tinggi: String,
    val umur: String,
    val url_foto: List<String>
)

val dummyDataOrangHilang = OrangHilangDummy(
    error = false,
    message = "Success",
    data = listOf(
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/Thor_Odinson/UcGMLtbocxDXExPvwywI.jpg",
                "gs://seek-out/stored_image/Thor_Odinson/KLtGmBPrHZdjtZOtuvFv.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "Thor Odinson",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/UcGMLtbocxDXExPvwywI.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/KLtGmBPrHZdjtZOtuvFv.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/Thor_Odinson/vjGAlOxbjjdGxMQREHnz.jpg",
                "gs://seek-out/stored_image/Thor_Odinson/kdRWRjdaaYScilgwgOuP.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "Thor Odinson",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/vjGAlOxbjjdGxMQREHnz.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/kdRWRjdaaYScilgwgOuP.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/chrish_hemsworth/taNUqLiRedZXjCPvRcNN.jpg",
                "gs://seek-out/stored_image/chrish_hemsworth/VFPnoCyeIuyVKNcMMyWC.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "chrish hemsworth",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/chrish_hemsworth/taNUqLiRedZXjCPvRcNN.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/chrish_hemsworth/VFPnoCyeIuyVKNcMMyWC.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/Thor_Odinson/UcGMLtbocxDXExPvwywI.jpg",
                "gs://seek-out/stored_image/Thor_Odinson/KLtGmBPrHZdjtZOtuvFv.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "Thor Odinson",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/UcGMLtbocxDXExPvwywI.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/KLtGmBPrHZdjtZOtuvFv.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/Thor_Odinson/vjGAlOxbjjdGxMQREHnz.jpg",
                "gs://seek-out/stored_image/Thor_Odinson/kdRWRjdaaYScilgwgOuP.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "Thor Odinson",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/vjGAlOxbjjdGxMQREHnz.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/kdRWRjdaaYScilgwgOuP.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/chrish_hemsworth/taNUqLiRedZXjCPvRcNN.jpg",
                "gs://seek-out/stored_image/chrish_hemsworth/VFPnoCyeIuyVKNcMMyWC.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "chrish hemsworth",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/chrish_hemsworth/taNUqLiRedZXjCPvRcNN.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/chrish_hemsworth/VFPnoCyeIuyVKNcMMyWC.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/Thor_Odinson/UcGMLtbocxDXExPvwywI.jpg",
                "gs://seek-out/stored_image/Thor_Odinson/KLtGmBPrHZdjtZOtuvFv.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "Thor Odinson",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/UcGMLtbocxDXExPvwywI.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/KLtGmBPrHZdjtZOtuvFv.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/Thor_Odinson/vjGAlOxbjjdGxMQREHnz.jpg",
                "gs://seek-out/stored_image/Thor_Odinson/kdRWRjdaaYScilgwgOuP.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "Thor Odinson",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/vjGAlOxbjjdGxMQREHnz.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/Thor_Odinson/kdRWRjdaaYScilgwgOuP.jpg"
            )
        ),
        OrangHilang(
            berat_badan = "60",
            ciri_fisik = "kekar dan keriting",
            foto = listOf(
                "gs://seek-out/stored_image/chrish_hemsworth/taNUqLiRedZXjCPvRcNN.jpg",
                "gs://seek-out/stored_image/chrish_hemsworth/VFPnoCyeIuyVKNcMMyWC.jpg"
            ),
            gender = "laki-laki",
            isFound = false,
            kota = "Banjarbaru",
            nama = "chrish hemsworth",
            nomor_dihubungi = "083159236448",
            sering_ditemukan_di = "area a",
            tinggi = "170",
            umur = "20",
            url_foto = listOf(
                "https://storage.googleapis.com/seek-out/stored_image/chrish_hemsworth/taNUqLiRedZXjCPvRcNN.jpg",
                "https://storage.googleapis.com/seek-out/stored_image/chrish_hemsworth/VFPnoCyeIuyVKNcMMyWC.jpg"
            )
        )
    )
)

