package com.example.android_studio_test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNew extends AppCompatActivity {

    private TextView getTvDataPassed;
    private TextView tvDataPassed;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        tvDataPassed = findViewById(R.id.tvNxtActivity);

        Bundle bundle = getIntent().getExtras();

        String value1 = bundle.getString("Value1","");

        tvDataPassed.setText(value1);







    }

}
