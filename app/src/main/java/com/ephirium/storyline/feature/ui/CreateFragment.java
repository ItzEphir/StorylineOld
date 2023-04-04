package com.ephirium.storyline.feature.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.FragmentCreateBinding;

public class CreateFragment extends Fragment {

    private FragmentCreateBinding binding;

    public CreateFragment() {
    }

    public static CreateFragment newInstance() {
        return new CreateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateBinding.inflate(getLayoutInflater());

        binding.storyText.setCustomSelectionActionModeCallback(new ActionMode.Callback2() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.text_select_menu, menu.addSubMenu("Format"));
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

        return binding.getRoot();
    }
}