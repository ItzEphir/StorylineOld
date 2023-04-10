package com.ephirium.storyline.feature.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnticipateInterpolator;

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.ActivityMainBinding;
import com.ephirium.storyline.feature.util.FragmentHolder;
import androidx.core.splashscreen.SplashScreen.Companion;

public class MainActivity extends AppCompatActivity implements FragmentHolder {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashScreen.installSplashScreen(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRoot().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                binding.getRoot().getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            onNavigationItemSelected(item);
            return true;
        });

        binding.bottomNavigation.setSelectedItemId(R.id.posts);

        startFragment(PostsPageFragment.newInstance(), false);

    }

    @Override
    public void startFragment(Fragment fragment, boolean backStackNeeded) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment);
        if (backStackNeeded) transaction.addToBackStack(null);
        transaction.commit();
    }

    @SuppressLint("NonConstantResourceId")
    private void onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.posts:
                startFragment(PostsPageFragment.newInstance(), true);
                break;
            case R.id.create:
                startFragment(CreateFragment.newInstance(), true);
                break;
            case R.id.profile:
                startFragment(ProfileFragment.newInstance(), true);
                break;
        }
    }
}