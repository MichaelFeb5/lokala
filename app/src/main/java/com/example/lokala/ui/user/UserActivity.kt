package com.example.lokala.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.lokala.R
import com.example.lokala.databinding.ActivityUserBinding
import com.example.lokala.ui.pemerintah.home.HomeFragment
import com.example.lokala.ui.user.home_fragment.HomeFragmentUser
import com.example.lokala.ui.user.search.SearchUserFragment


class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAction()

        with(binding) {
            bottomNavigation.setOnClickMenuListener {
                when(it.id) {
                    1 -> navigation(HomeFragmentUser())
                    2 -> navigation(SearchUserFragment())
                }
            }
        }



    }

    private fun initAction() {
        with(binding) {
            bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.baseline_home_24))
            bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.baseline_search_24))
            bottomNavigation.show(1,true)
            navigation(HomeFragmentUser())
        }
    }

    private fun navigation(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_user, fragment)
        fragmentTransaction.commit()
        updateBottomNavigation(fragment)
    }

    private fun updateBottomNavigation(fragment: Fragment) {
        val selectedItem = when (fragment) {
            is HomeFragment -> 1
            is SearchUserFragment -> 2
//            is EventFragment -> 3
            else -> return
        }
        binding.bottomNavigation.show(selectedItem, true)
    }

}