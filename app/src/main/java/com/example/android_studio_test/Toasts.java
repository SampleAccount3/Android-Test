package com.example.android_studio_test;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Toasts extends AppCompatActivity {

    public void ToastMakerShort(Context context,String Text){
        Toast.makeText(context, Text, Toast.LENGTH_SHORT).show();
    }
    public void ToastMakerLong(Context context,String Text){
        Toast.makeText(context, Text, Toast.LENGTH_LONG).show();
    }
}
