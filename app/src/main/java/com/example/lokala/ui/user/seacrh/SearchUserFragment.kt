package com.example.lokala.ui.user.seacrh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lokala.R
import com.example.lokala.adapter.UserOrangHilangAdapter
import com.example.lokala.data.dummy.OrangHilang
import com.example.lokala.data.dummy.dummyDataOrangHilang
import com.example.lokala.databinding.FragmentSearchUserBinding


class SearchUserFragment : Fragment() {


    private var _binding: FragmentSearchUserBinding? = null
    private val binding get() = _binding!!
    private val genderOptions by lazy {
        resources.getStringArray(R.array.choice_gender)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchUserBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listuser = dummyDataOrangHilang.data
        showRvList(listuser)
        genderOption()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //for show list user
    private fun showRvList(list: List<OrangHilang>) {
        with(binding) {
            val adapter = UserOrangHilangAdapter()
            adapter.submitList(list)
            rvUserOrangHilang.adapter = adapter

            adapter.setOnItemClickCallback(object : UserOrangHilangAdapter.OnItemClickCalback {
                override fun onItemClicked(item: OrangHilang) {
                   //detail activity
                    Toast.makeText(requireContext(),item.nama,Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun genderOption() {

        val adapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,genderOptions)
        binding.genderChoice.setAdapter(adapter)

    }


}