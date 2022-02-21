package com.wikilift.uf1_practico.ui.splash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;


import android.os.Handler;

import android.view.View;

import com.wikilift.uf1_practico.R;
import com.wikilift.uf1_practico.databinding.FragmentSplashBinding;

public class Splash extends Fragment {


    private FragmentSplashBinding binding;

    public Splash() {
        super(R.layout.fragment_splash);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding= FragmentSplashBinding.bind(view);
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Navigation.findNavController(view).navigate(R.id.action_splash_to_landingLayout);
            }
        }, 3000);




    }
}