package com.ephirium.storyline.ui.fragment;


import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.storyline.R

import com.ephirium.storyline.databinding.FragmentDescriptionStoryBinding;

class DescriptionStoryFragment : Fragment(R.layout.fragment_description_story) {

    private val binding: FragmentDescriptionStoryBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}