package com.ephirium.storyline.feature.ui.auth.fragment;

import static com.ephirium.storyline.StorylineLog.logError;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ephirium.storyline.databinding.FragmentSignInBinding;
import com.ephirium.storyline.feature.ui.auth.AuthActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SignInFragment extends Fragment {

    private FragmentSignInBinding binding;

    public SignInFragment() {
    }

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(getLayoutInflater());

        binding.loginButton.setOnClickListener(v -> {
            if (binding.layoutAuth.login.getText() != null
                    && binding.layoutAuth.password.getText() != null
                    && !binding.layoutAuth.login.getText().toString().isEmpty()
                    && !binding.layoutAuth.password.getText().toString().isEmpty()) {
                String login = binding.layoutAuth.login.getText().toString();
                String password = binding.layoutAuth.password.getText().toString();

                FirebaseAuth.getInstance().signInWithEmailAndPassword(login, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                if (getActivity() != null) getActivity().finishAffinity();
                            } else {
                                if (getActivity() != null)
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "Sign in failed\nWrong login or password",
                                            Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(e -> {
                            logError(e.toString(), SignInFragment.class);
                        });
            }
        });

        binding.signup.setOnClickListener(v -> {
            if (getActivity() instanceof AuthActivity)
                ((AuthActivity) getActivity()).startFragment(SignUpFragment.newInstance(), false);
        });

        return binding.getRoot();
    }
}