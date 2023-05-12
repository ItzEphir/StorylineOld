package com.ephirium.storyline.ui.main.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ephirium.storyline.databinding.FragmentDescriptionStoryBinding;

public class DescriptionStoryFragment extends Fragment {

    private FragmentDescriptionStoryBinding binding;

    public DescriptionStoryFragment() {
        // default
    }

    public static DescriptionStoryFragment newInstance(){
        return new DescriptionStoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDescriptionStoryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}