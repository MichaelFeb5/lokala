package com.example.lokala.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lokala.data.dummy.OrangHilang
import com.example.lokala.data.dummy.dummyDataOrangHilang
import com.example.lokala.databinding.FragmentHomeBinding
import com.example.lokala.ui.orangHilang.DetailOrangHilangActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val orangHilangAdapter = OrangHilangAdapter(requireContext(), dummyDataOrangHilang.data)
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
}