package com.example.android_studio_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClickMe,btnUpgrade;

    TextView tvScore,tvTitle1,tvDescription1;
    double Score = 0f;
    double upgradeIncrement = 0f;
    double ScoreIncrement = 1f;
    double price = 1f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            Score = savedInstanceState.getDouble("Score");
            upgradeIncrement = savedInstanceState.getDouble("upgradeIncrement");
            ScoreIncrement = savedInstanceState.getDouble("ScoreIncrement");
            price = savedInstanceState.getDouble("price");
        }

        Declarations();
        tvScore = findViewById(R.id.tvScore);
        tvDescription1 = findViewById(R.id.tvDescription);

        tvDescription1.setText(String.valueOf(Math.round(price)));
        runTimer();


        btnClickMe.setOnClickListener(v ->{
            Score += ScoreIncrement;
            tvScore.setText( String.valueOf(Math.round(Score)));
        });
        btnUpgrade.setOnClickListener(v ->{
            if (Score > price){
                ScoreIncrement *= 1.5;
                tvScore.setText( String.valueOf(Math.round(Score)));
                upgradeIncrement +=ScoreIncrement;
                tvTitle1.setText("Total DPC: "+ String.valueOf(Math.round(ScoreIncrement)));
                price += price * 1.8;
                Score -= price;
                tvDescription1.setText(String.valueOf(Math.round(price)));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {

        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putDouble("Score", Score);
        saveInstanceState.putDouble("upgradeIncrement", upgradeIncrement);
        saveInstanceState.putDouble("ScoreIncrement", ScoreIncrement);
        saveInstanceState.putDouble("price", price);
    }

    private void Declarations(){
        btnClickMe = findViewById(R.id.btnClickMe);
        btnUpgrade = findViewById(R.id.btnUpgrade1);
        tvTitle1 = findViewById(R.id.tvTitle1);
        tvDescription1 = findViewById(R.id.tvDescription);

    }

    private void runTimer(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (Score < 0){
                    Score =0;
                }
                    Score += upgradeIncrement;
                    tvScore.setText(String.valueOf(Math.round(Score)));
                    handler.postDelayed(this,1000);
            }
        });
    }

}