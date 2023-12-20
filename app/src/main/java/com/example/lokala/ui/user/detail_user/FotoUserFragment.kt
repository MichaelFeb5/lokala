package com.example.lokala.ui.user.detail_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lokala.R
import com.example.lokala.databinding.FragmentFotoUserBinding

class FotoUserFragment : Fragment() {


    private var _binding: FragmentFotoUserBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFotoUserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val index = requireArguments().getInt(ARG_POSITION, 0)
            selectedCircle(index)

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
                    circle1Foto.setImageResource(R.drawable.selected_circle)
                    circle2Foto.setImageResource(R.drawable.unselected_circle)
                }

                else -> {
                    circle1Foto.setImageResource(R.drawable.unselected_circle)
                    circle2Foto.setImageResource(R.drawable.selected_circle)
                }


            }
        }
    }


    companion object {

        const val ARG_POSITION = "arg_position"
        const val ARG_IMAGE = "arg_image"


    }


}