package com.kyoudai.travelbuddy

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kyoudai.travelbuddy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

        val navHostFragment = findViewById<View>(R.id.nav_host_fragment_activity_main)

        // Add a listener to get the height after layout is completed
        navView.viewTreeObserver.addOnGlobalLayoutListener {
            val navViewHeight = navView.height
            navHostFragment.setPadding(
                navHostFragment.paddingLeft,
                navHostFragment.paddingTop,
                navHostFragment.paddingRight,
                navViewHeight // Set paddingBottom to the height of BottomNavigationView
            )
        }
    }
}