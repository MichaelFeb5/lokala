package com.example.lokala.ui.user.search

import ResultState
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lokala.R
import com.example.lokala.ui.adapter.UserOrangHilangAdapter
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.FragmentSearchUserBinding
import com.example.lokala.ui.factory.ViewModelFactory
import com.example.lokala.ui.fragment_utils.LoadingDialogFragment
import com.example.lokala.ui.pemerintah.orangHilang.detail.DetailOrangHilangActivity
import com.example.lokala.ui.user.detail.UserDetailOrangHilangActivity


class SearchUserFragment : Fragment() {


    private var _binding: FragmentSearchUserBinding? = null
    private lateinit var factory: ViewModelFactory
    private val viewModel: SearchUserViewModel by viewModels { factory }

    private val binding get() = _binding!!
    private val genderOptions by lazy {
        resources.getStringArray(R.array.choice_gender)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(false)
        showDataKosong(true)
        genderOption()
        setViewModelFactory()
        val loadingDialog = LoadingDialogFragment()


        binding.btnSearchUser.setOnClickListener {

            val nama = binding.edSrcName.text.toString().trim()
            val kota = binding.edSrcLocation.text.toString().trim()
            val gender = binding.genderChoice.text.toString().trim()

            // Memeriksa apakah nama, kota, atau gender kosong
            val isNamaEmpty = nama.isEmpty()
            val isKotaEmpty = kota.isEmpty()
            val isGenderEmpty = gender.isEmpty()

            // Menyesuaikan nilai-nilai yang kosong
            val adjustedNama = if (isNamaEmpty) "" else nama
            val adjustedKota = if (isKotaEmpty) "" else kota
            val adjustedGender = if (isGenderEmpty) "" else gender

            viewModel.getOrangHilangByName(adjustedNama,adjustedKota,adjustedGender).observe(viewLifecycleOwner) { result ->
                when (result) {
                    is ResultState.Loading -> {
                        // Handle loading state if needed
                        showDataKosong(false)
                        loadingDialog.show(childFragmentManager, "loading")
                    }

                    is ResultState.Success -> {
                        loadingDialog.dismiss()
                        binding.tvPeopleHasil.setText(
                             "Orang Ditemukan : ${result.data.data.size} Orang"
                        )

                        if(result.data.data.size == 0) {
                            showDataKosong(true)
                        }
                        showRvList(result.data.data)
                    }

                    is ResultState.Error -> {
                        // Handle error state
                        showLoading(false)
                        showToast("Server Error")
                    }

                    else -> {}
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //for show list user
    private fun showRvList(list: List<OrangHilangItem>) {
        with(binding) {
            val adapter = UserOrangHilangAdapter()
            adapter.submitList(list)
            rvUserOrangHilang.adapter = adapter

            adapter.setOnItemClickCallback(object : UserOrangHilangAdapter.OnItemClickCalback {
                override fun onItemClicked(item: OrangHilangItem) {
                    //detail activity
                    val intent = Intent(requireContext(), UserDetailOrangHilangActivity::class.java)
                    intent.putExtra("EXTRA_ORANG_HILANG", item)
                    startActivity(intent)
                }
            })
        }
    }

    private fun genderOption() {

        val adapter = ArrayAdapter(
            requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            genderOptions
        )
        binding.genderChoice.setAdapter(adapter)

    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar3.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showDataKosong(isLoading: Boolean) {
        binding.tvDataTidakDitemukan.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun setViewModelFactory() {
        factory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun showToast(message: String) {
        Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
    }


}