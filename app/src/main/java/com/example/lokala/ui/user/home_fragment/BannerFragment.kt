package com.example.lokala.ui.user.home_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lokala.R
import com.example.lokala.databinding.FragmentBannerBinding


class BannerFragment : Fragment() {


    private var _binding: FragmentBannerBinding? = null
    private val binding = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBannerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val ARG_POSITION = "arg_position"


    }
}