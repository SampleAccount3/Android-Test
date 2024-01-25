package com.example.android_studio_test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNew extends AppCompatActivity {

    private TextView tvDataPassed;
    //Declaring a static final string so the other activities can access it
    //The Naming convention is MESSAGENAME_RECEIVED
    public static final String MESSAGE_RECEIVED = "MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        tvDataPassed = findViewById(R.id.tvNxtActivity);

        Bundle bundle = getIntent().getExtras();
        Intent getIntent = getIntent();

        String ValueSample = getIntent.getStringExtra(MESSAGE_RECEIVED);
        String value1 = bundle.getString(MESSAGE_RECEIVED,"");

//        Toast.makeText(this, ValueSample, Toast.LENGTH_SHORT).show();

        tvDataPassed.setText(ValueSample);

    }

}
