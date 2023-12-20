package com.example.lokala.ui.user.detail_user

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lokala.R
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.ActivityDetailUserBinding
import com.example.lokala.utils.toEditable

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(ARG_ORANG_HILANG, OrangHilangItem::class.java)
        } else {
            intent.getParcelableExtra(ARG_ORANG_HILANG)
        }

        if (data != null) {
            initAction(data)
        }



    }

    private fun initAction(data: OrangHilangItem) {
        with(binding) {
            setStatus(data)
            tvNamaUser.text = data.nama
            tvUserGender.text = data.gender
            tvUserBerat.text = "${data.beratBadan} Kg"
            tvUserUsia.text= "${data.umur} Tahun"
            tvLokasiUser.text = data.kota.toEditable()
            tvUserSeringDitemukan.text = data.seringDitemukanDi.toEditable()
            tvUserCiriFisik.text= data.ciriFisik.toEditable()

        }
    }

    private fun setStatus(data: OrangHilangItem){

        var result: String
        with(binding) {
            if (data.isFound) {
                result = resources.getString(R.string.ditemukan)
                tvUserStatus.text = result
                tvUserStatus.setTextColor(getColor(R.color.green))
            } else {
                result = resources.getString(R.string.hilang)
                tvUserStatus.text = result
                tvUserStatus.setTextColor(getColor(R.color.red))

            }
        }



    }



    companion object {
        const val ARG_ORANG_HILANG = "orang_hilang"
    }
}