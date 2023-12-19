package com.example.lokala.ui.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lokala.R
import com.example.lokala.databinding.FragmentGuideBinding


class GuideFragment : Fragment() {


    private var _binding: FragmentGuideBinding? = null
    private val binding get() = _binding!!
    private val titleFragment: Array<String> by lazy {
        resources.getStringArray(R.array.title_guide_fragment)
    }
    private val titleCardFragment: Array<String> by lazy {
        resources.getStringArray(R.array.title_card_guide)
    }
    private val imageLandingPage by lazy {
        resources.obtainTypedArray(R.array.image_landing_page)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGuideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = arguments?.getInt(ARG_POSITION, 0)

        index?.let {
            with(binding) {
                tvTitleGuide.text = titleFragment[it]
                tvTitleCard.text = titleCardFragment[it]
                selectedCircle(it)

                Glide.with(requireContext())
                    .load(imageLandingPage.getResourceId(it,0))
                    .into(imageGuide)
                
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun selectedCircle(position: Int) {
        with(binding) {
            when (position) {

                0 -> {
                    circle1.setImageResource(R.drawable.selected_circle)
                    circle2.setImageResource(R.drawable.unselected_circle)
                    circle3.setImageResource(R.drawable.unselected_circle)
                }

                else -> {
                    circle1.setImageResource(R.drawable.unselected_circle)
                    circle2.setImageResource(R.drawable.selected_circle)
                    circle3.setImageResource(R.drawable.unselected_circle)
                }
            }
        }

    }

    companion object {

        const val ARG_POSITION = "arg_position"

    }

}