package com.ephirium.storyline.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.storyline.R
import com.ephirium.storyline.databinding.FragmentTabBinding

class TabFragment : Fragment(R.layout.fragment_tab) {

    private val binding: FragmentTabBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = binding.tabFragmentContainer.getFragment<NavHostFragment>()
        val navController = navHost.navController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }
}