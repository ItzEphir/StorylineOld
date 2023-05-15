package com.ephirium.storyline.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import by.kirich1409.viewbindingdelegate.viewBinding

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.FragmentCreateBinding;

class CreateFragment : Fragment(R.layout.fragment_create) {

    private val binding : FragmentCreateBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.storyText.customSelectionActionModeCallback = object : ActionMode.Callback2(){
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                val inflater = mode?.menuInflater;
                inflater?.inflate(R.menu.text_select_menu, menu?.addSubMenu("Format"));
                return true;
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?) = true

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {

                return true
            }

            override fun onDestroyActionMode(mode: ActionMode?) { }

        }
    }
}