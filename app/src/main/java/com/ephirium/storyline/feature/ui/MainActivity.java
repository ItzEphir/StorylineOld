package com.ephirium.storyline.feature.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.ephirium.storyline.R;
import com.ephirium.storyline.databinding.ActivityMainBinding;
import com.ephirium.storyline.feature.ui.CreateFragment;
import com.ephirium.storyline.feature.ui.PostsPageFragment;
import com.ephirium.storyline.feature.ui.ProfileFragment;
import com.ephirium.storyline.feature.util.FragmentHolder;

public class MainActivity extends AppCompatActivity implements FragmentHolder {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigation.setOnItemSelectedListener(item -> { onNavigationItemSelected(item); return true; });

        binding.bottomNavigation.setSelectedItemId(R.id.posts);

        startFragment(PostsPageFragment.newInstance(), false);
    }

    @Override
    public void startFragment(Fragment fragment, boolean backStackNeeded) {
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment);
        if(backStackNeeded) transaction.addToBackStack(null);
        transaction.commit();
    }

    @SuppressLint("NonConstantResourceId")
    private void onNavigationItemSelected(MenuItem item){
        switch (item.getItemId()){
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