package com.example.lokala.ui.guide

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lokala.R
import com.example.lokala.databinding.FragmentChoiceUserBinding
import com.example.lokala.ui.pemerintah.home.MainActivity
import com.example.lokala.ui.pemerintah.login.LoginActivity
import com.example.lokala.ui.user.UserActivity


class FragmentChoiceUser : Fragment() {

    private var _binding: FragmentChoiceUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChoiceUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectedCircle()

        with(binding) {

            btnUser.setOnClickListener {
                val intent = Intent(requireContext(),UserActivity::class.java)
                startActivity(intent)
            }

            btnGovernment.setOnClickListener {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
            }


        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun selectedCircle() {
        with(binding) {
            circle1ChoiceUser.setImageResource(R.drawable.unselected_circle)
            circle2ChoiceUser.setImageResource(R.drawable.unselected_circle)
            circle3ChoiceUser.setImageResource(R.drawable.selected_circle)
        }
    }


}