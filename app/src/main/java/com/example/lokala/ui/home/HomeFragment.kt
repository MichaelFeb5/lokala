package com.example.lokala.ui.home

import ResultState
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lokala.data.dummy.OrangHilang
import com.example.lokala.data.response.OrangHilangItem
import com.example.lokala.databinding.FragmentHomeBinding
import com.example.lokala.ui.factory.ViewModelFactory
import com.example.lokala.ui.orangHilang.DetailOrangHilangActivity
import com.example.lokala.ui.orangHilang.TambahOrangHilangActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var factory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModelFactory()

        binding.btnTambah.setOnClickListener {
            val intent = Intent(requireContext(), TambahOrangHilangActivity::class.java)
            startActivity(intent)
        }

//        initRecyclerView()

        viewModel.getOrangHilang().observe(viewLifecycleOwner) { result ->
            if (result != null) {
                when (result) {
                    is ResultState.Loading -> {
//                        showLoading(true)
                    }

                    is ResultState.Success -> {
                        Log.d("Tes",result.data.toString())
//                        showOrangHilang(result.data.data)
                    }

                    is ResultState.Error -> {

                    }

                    else -> {}
                }
            }
        }
    }

    private fun setViewModelFactory() {
        factory = ViewModelFactory.getInstance(binding.root.context)
    }

    private fun showOrangHilang(orangHilangs: List<OrangHilangItem>) {
        val orangHilangAdapter = OrangHilangAdapter(requireContext(), orangHilangs)
        val spanCount = 1
        binding.rvOrangHilang.apply {
            layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
            adapter = orangHilangAdapter
        }

        orangHilangAdapter.setOnItemClickListener(object : OrangHilangAdapter.OnItemClickListener {
            override fun onClick(ivOrangHilang: ImageView, orangHilang: OrangHilang) {
                val intent = Intent(requireContext(), DetailOrangHilangActivity::class.java)
                intent.putExtra("EXTRA_ORANG_HILANG", orangHilang)
                startActivity(intent)
            }
        })
    }

//    private fun initRecyclerView() {
//        val orangHilangAdapter = OrangHilangAdapter(requireContext(), dummyDataOrangHilang.data)
//        val spanCount = 1
//        binding.rvOrangHilang.apply {
//            layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
//            adapter = orangHilangAdapter
//        }
//
//        orangHilangAdapter.setOnItemClickListener(object : OrangHilangAdapter.OnItemClickListener {
//            override fun onClick(ivOrangHilang: ImageView, orangHilang: OrangHilang) {
//                val intent = Intent(requireContext(), DetailOrangHilangActivity::class.java)
//                intent.putExtra("EXTRA_ORANG_HILANG", orangHilang)
//                startActivity(intent)
//            }
//        })
//    }
}