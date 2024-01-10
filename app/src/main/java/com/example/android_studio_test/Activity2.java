package com.example.android_studio_test;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Activity2 extends AppCompatActivity {
    private TextView ac2TV1,ac2TV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Bundle extras = getIntent().getExtras();

        ac2TV1 = findViewById(R.id.tvActivity22);
        ac2TV2 = findViewById(R.id.tvActivity23);

        String valueA = extras.getString("ValueA");
        String valueB = extras.getString("ValueB");
        ac2TV1.setText("Value A: "+ valueA );
        ac2TV2.setText("Value B: "+ valueB);

        Toast.makeText(this,"Value A: " + valueA +"\n" + "Value B: " + valueB ,Toast.LENGTH_SHORT).show();







    }

}
