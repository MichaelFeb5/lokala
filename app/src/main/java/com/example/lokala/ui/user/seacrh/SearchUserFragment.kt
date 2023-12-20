package com.example.lokala.ui.user.seacrh

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
import com.example.lokala.adapter.UserOrangHilangAdapter
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.FragmentSearchUserBinding
import com.example.lokala.ui.factory.ViewModelFactory
import com.example.lokala.ui.user.detail_user.DetailUserActivity


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

        binding.btnSearchUser.setOnClickListener {
            val nama = binding.edSrcName.text.toString()
            viewModel.getOrangHilangByName(nama).observe(viewLifecycleOwner) { result ->
                when (result) {
                    is ResultState.Loading -> {
                        // Handle loading state if needed
                        showDataKosong(false)
                        showLoading(true)
                    }

                    is ResultState.Success -> {
                        // Handle success state
                        showLoading(false)
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

                    val intent = Intent(requireContext(), DetailUserActivity::class.java)
                    intent.putExtra(DetailUserActivity.ARG_ORANG_HILANG, item)
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