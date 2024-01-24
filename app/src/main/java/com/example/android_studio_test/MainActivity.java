package com.example.android_studio_test;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSendData;
    EditText edData;
    String DataToPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendData = findViewById(R.id.btnSendData);
        edData = findViewById(R.id.edData);
        Intent intent = new  Intent(getApplicationContext(),ActivityNew.class);


        btnSendData.setOnClickListener(view -> {
            Toast.makeText(this, "Sample", Toast.LENGTH_SHORT).show();
            DataToPass = edData.getText().toString();
            intent.putExtra("Value1",DataToPass);
            startActivity(intent);
        });

    }
}