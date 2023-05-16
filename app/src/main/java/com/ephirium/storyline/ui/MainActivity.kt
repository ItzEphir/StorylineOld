package com.ephirium.storyline.ui

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.common.log.info
import com.ephirium.common.log.log

import com.ephirium.storyline.R
import com.ephirium.storyline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        info("Main")

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()


        // navController =
        //     (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
        // log("Main")
        // NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}