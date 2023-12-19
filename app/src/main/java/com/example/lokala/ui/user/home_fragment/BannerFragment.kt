package com.example.lokala.ui.user.home_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lokala.R
import com.example.lokala.databinding.FragmentBannerBinding


class BannerFragment : Fragment() {


    private var _binding: FragmentBannerBinding? = null
    private val binding = _binding!!
    private val bannerGovernment by lazy {
        resources.getStringArray(R.array.banner_image)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBannerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = arguments?.getInt(ARG_POSITION, 0)

        Glide.with(requireContext())
            .load(bannerGovernment[index!!])
            .into(binding.imageBanner)

        selectedCircle(index)


    }

    private fun selectedCircle(position: Int) {

        with(binding) {
            when(position) {
                0 -> circle1Banner.setImageResource(R.drawable.selected_circle)
                1 -> circle2Banner.setImageResource(R.drawable.selected_circle)
                2 -> circle3Banner.setImageResource(R.drawable.selected_circle)
                3 -> circle4Banner.setImageResource(R.drawable.selected_circle)
                else -> circle5Banner.setImageResource(R.drawable.selected_circle)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val ARG_POSITION = "arg_position"


    }
}