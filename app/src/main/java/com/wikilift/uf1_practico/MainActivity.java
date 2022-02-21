package com.wikilift.uf1_practico;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;


import androidx.core.content.ContextCompat;

import androidx.navigation.NavController;

import androidx.navigation.fragment.NavHostFragment;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wikilift.uf1_practico.core.helpers.Helpers;
import com.wikilift.uf1_practico.data.local.DatabaseApp;
import com.wikilift.uf1_practico.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;
    public static DatabaseApp masterDB;
    private  BottomNavigationView bottomNavigationView;
    public static com.google.android.material.appbar.MaterialToolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        masterDB=new DatabaseApp(this);



        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.d(Helpers.TAG,"hello");
        getMenuInflater().inflate(R.menu.upmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.landingLayout:
                navController.navigateUp();
                navController.navigate(R.id.landingLayout);

                return true;
            case R.id.deleteTasks:

                    navController.navigateUp();
                    navController.navigate(R.id.deleteTasks);
                    return true;
            case R.id.createNewNote:
                navController.navigateUp();
                navController.navigate(R.id.createNewNote);
            return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }
}