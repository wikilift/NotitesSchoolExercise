package com.wikilift.uf1_practico.core.helpers;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.wikilift.uf1_practico.MainActivity;
import com.wikilift.uf1_practico.R;

public class Helpers {
    public final static String TAG="Jhon Doe";
    public static void hide(View v){
        v.setVisibility(View.GONE);
    }
    public static void show(View v){
        v.setVisibility(View.VISIBLE);
    }
    public static void hideKeyboard(Context con, View v){
        InputMethodManager inputMethodManager= (InputMethodManager) con.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromInputMethod(v.getWindowToken(),0);
    }
    public static void makeSnack(View view,String msg,Context con){
       Snackbar.make(view,msg,Snackbar.LENGTH_LONG)
               .setTextColor(con.getResources().getColor(R.color.Crimson))
               .setBackgroundTint(con.getResources().getColor(R.color.WhiteSmoke))
               .show();
    }


}
