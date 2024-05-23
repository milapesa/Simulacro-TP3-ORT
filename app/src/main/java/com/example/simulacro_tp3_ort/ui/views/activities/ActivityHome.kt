package com.example.simulacro_tp3_ort.ui.views.activites

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.simulacro_tp3_ort.R
import com.google.android.material.navigation.NavigationView

class ActivityHome : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lay_activity_home)

        drawerLayout = findViewById(R.id.activity_home_draweLayout)
        navigationView = findViewById(R.id.activity_home_navigationView)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        setupDrawerLayout()
    }

    private fun setupDrawerLayout() {
        val navController = navHostFragment.navController

        navigationView.setupWithNavController(navController)

        //NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        /*navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.id.menu)

        }*/
    }
}