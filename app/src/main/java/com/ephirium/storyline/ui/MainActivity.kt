package com.ephirium.storyline.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import by.kirich1409.viewbindingdelegate.viewBinding

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.ActivityMainBinding;

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val navHost = binding.fragmentContainer.getFragment<NavHostFragment>()
        navController = navHost.navController

        NavigationUI.setupActionBarWithNavController(this, navController!!)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.navigateUp() == true || super.onSupportNavigateUp()
    }

}