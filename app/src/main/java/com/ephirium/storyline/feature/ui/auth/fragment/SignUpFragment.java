package com.ephirium.storyline.feature.ui.auth.fragment;

import static com.ephirium.storyline.StorylineLog.logError;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.FragmentSignUpBinding;
import com.ephirium.storyline.feature.ui.auth.AuthActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseAuthRegistrar;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

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

        binding.loginButton.setOnClickListener(v -> {
            if (binding.layoutAuth.login.getText() != null
                    && binding.layoutAuth.password.getText() != null
                    && binding.email.getText() != null
                    && !binding.layoutAuth.login.getText().toString().isEmpty()
                    && !binding.layoutAuth.password.getText().toString().isEmpty()
                    && !binding.email.getText().toString().isEmpty()) {
                String login = binding.layoutAuth.login.getText().toString();
                String password = binding.layoutAuth.password.getText().toString();
                String email = binding.email.getText().toString();

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                if (getActivity() != null) {
                                    getActivity().finishAffinity();
                                }
                            } else {
                                if (getActivity() != null)
                                    Toast.makeText(getActivity().getApplicationContext(),
                                            "Sign up failed\nUser already exists",
                                            Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(e -> {
                            logError(e.toString(), SignInFragment.class);
                        });
            }
        });

        binding.signin.setOnClickListener(v -> {
            if (getActivity() instanceof AuthActivity)
                ((AuthActivity) getActivity()).startFragment(SignInFragment.newInstance(), false);
        });

        return binding.getRoot();
    }
}