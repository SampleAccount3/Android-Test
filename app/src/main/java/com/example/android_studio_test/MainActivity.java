package com.example.android_studio_test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Toasts toasts = new Toasts();
    Spinner spinner;
    String spinnerValue;

    private Button btnSample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSample = findViewById(R.id.btnClickSample);
        spinner = findViewById(R.id.spinSample);

        btnSample.setOnClickListener(v -> {
            spinnerValue = String.valueOf(spinner.getSelectedItem());
            toasts.ToastMakerShort(MainActivity.this,spinnerValue);
        });




    }
}