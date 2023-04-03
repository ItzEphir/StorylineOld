package com.ephirium.storyline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ephirium.storyline.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRandomText();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void setRandomText(){
        int a = (int)(Math.random() * 2);

        Log.d("Mytag", String.valueOf(a));

        String s = "";

        switch (a){
            case 0:
                s = "Reading is fun, writing is number-one!";
                break;
            case 1:
                s = "Читать весело, писать здорово!";
                break;
        }

        binding.text.setText(s);
    }
}