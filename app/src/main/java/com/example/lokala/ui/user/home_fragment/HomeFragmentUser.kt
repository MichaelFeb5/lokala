package com.example.lokala.ui.user.home_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lokala.ui.adapter.BannerViewPagerAdapter
import com.example.lokala.databinding.FragmentHomeUserBinding
import com.example.lokala.ui.user.foto.FotoActivity


class HomeFragmentUser : Fragment() {

    private var _binding: FragmentHomeUserBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            Glide.with(requireContext())
                .load("https://i.pinimg.com/originals/0d/1c/02/0d1c02ee48d48f5797cb54f15d1d6c34.jpg")
                .into(imExampleFoto)

            btnFind.setOnClickListener {
                val intent = Intent(requireContext(), FotoActivity::class.java)
                startActivity(intent)
            }

            val adapter = BannerViewPagerAdapter(this@HomeFragmentUser)
            bannerViewPager.adapter = adapter

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}