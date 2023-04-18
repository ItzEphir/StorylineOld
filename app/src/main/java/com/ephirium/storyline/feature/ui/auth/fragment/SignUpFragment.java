package com.ephirium.storyline.feature.ui.auth.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ephirium.storyline.databinding.FragmentSignUpBinding;
import com.ephirium.storyline.feature.ui.auth.AuthActivity;

public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;

    public SignUpFragment() {
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(getLayoutInflater());

        binding.signin.setOnClickListener(v -> {
            if (getActivity() instanceof AuthActivity)
                ((AuthActivity) getActivity()).startFragment(SignInFragment.newInstance(), false);
        });

        return binding.getRoot();
    }
}