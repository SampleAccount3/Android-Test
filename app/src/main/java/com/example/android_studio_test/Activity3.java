package com.example.android_studio_test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private TextView tvSharedPref1,tvSharedPref2;
    String str1,str2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpref);

        tvSharedPref1 = findViewById(R.id.tvSharedPref1);
        tvSharedPref2 = findViewById(R.id.tvSharedPref2);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("SamplePref", Context.MODE_PRIVATE);
        str1 = sp.getString("ValueA","");
        str2 = sp.getString("ValueB","");

        tvSharedPref1.setText(str1);
        tvSharedPref2.setText(str2);




    }
}
