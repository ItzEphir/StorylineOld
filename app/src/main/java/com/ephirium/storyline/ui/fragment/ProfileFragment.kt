package com.ephirium.storyline.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.storyline.R

import com.ephirium.storyline.ui.recyclerbase.BaseAdapter;
import com.ephirium.storyline.databinding.FragmentProfileBinding;
import com.ephirium.storyline.presentation.ProfileViewModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding: FragmentProfileBinding by viewBinding()

    private val adapter = BaseAdapter()

    private val viewModel: ProfileViewModel by lazy { ViewModelProvider(requireActivity())[ProfileViewModel::class.java] }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState != null){

        }
    }
}