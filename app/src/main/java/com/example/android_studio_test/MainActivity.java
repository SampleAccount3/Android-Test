package com.example.android_studio_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edUsername,edEmail,edAge;
    private Button btnSubmit;
    Account acc = new Account();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsername = findViewById(R.id.edUserName);
        edEmail = findViewById(R.id.edEmail);
        edAge = findViewById(R.id.edAge);
        btnSubmit = findViewById(R.id.btnSubmit);

    }

    @Override
    public void onClick(View v) {
        if (R.id.btnSubmit == v.getId()){
            acc.toString();
        }
    }
}
