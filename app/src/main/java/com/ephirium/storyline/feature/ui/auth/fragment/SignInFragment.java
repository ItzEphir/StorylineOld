package com.ephirium.storyline.feature.ui.auth.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ephirium.storyline.databinding.FragmentSignInBinding;
import com.ephirium.storyline.feature.ui.auth.AuthActivity;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;

    public SignInFragment() { }

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(getLayoutInflater());

        binding.signup.setOnClickListener(v -> {
            if(getActivity() instanceof AuthActivity)
                ((AuthActivity)getActivity()).startFragment(SignUpFragment.newInstance(), false);
        });

        return binding.getRoot();
    }
}