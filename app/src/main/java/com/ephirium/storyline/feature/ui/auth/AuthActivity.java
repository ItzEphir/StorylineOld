package com.ephirium.storyline.feature.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.ActivityAuthBinding;
import com.ephirium.storyline.feature.ui.auth.fragment.SignInFragment;
import com.ephirium.storyline.feature.util.FragmentHolder;

public class AuthActivity extends AppCompatActivity implements FragmentHolder {

    private ActivityAuthBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, AuthActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startFragment(SignInFragment.newInstance(), false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public void startFragment(Fragment fragment, boolean backStackNeeded) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.auth_container, fragment);
        if (backStackNeeded) transaction.addToBackStack(null);
        transaction.commit();
    }
}