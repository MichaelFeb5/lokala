package com.example.lokala.ui.pemerintah.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.lokala.R
import com.example.lokala.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.baseline_home_24))
            bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.baseline_search_24))
            bottomNavigation.show(1)
            navigation(HomeFragment(),true)

            bottomNavigation.setOnClickMenuListener {
                when (it.id) {
                    1 -> navigation(HomeFragment(),false)
//                    2 -> navigation(ScanFragment(),false)
//                    3 -> navigation(EventFragment(),false)
                }
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.removeOnBackStackChangedListener(onBackStackChangedListener)
    }

    private val onBackStackChangedListener =
        FragmentManager.OnBackStackChangedListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
            currentFragment?.let { updateBottomNavigation(it) }
        }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    private fun navigation(fragment: Fragment, first:Boolean) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        if (!first){
            fragmentTransaction.addToBackStack(null)}
        fragmentTransaction.commit()
        updateBottomNavigation(fragment)
    }

    private fun updateBottomNavigation(fragment: Fragment) {
        val selectedItem = when (fragment) {
            is HomeFragment -> 1
//            is ScanFragment -> 2
//            is EventFragment -> 3
            else -> return
        }
        binding.bottomNavigation.show(selectedItem, true)
    }
}