package com.example.android_studio_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ObjectBattery> objBat = new ArrayList<>();

    int[] imgBatteries = {R.drawable.baseline_battery_0_bar_24,
            R.drawable.baseline_battery_1_bar_24,
            R.drawable.baseline_battery_2_bar_24,
            R.drawable.baseline_battery_3_bar_24,
            R.drawable.baseline_battery_4_bar_24,
            R.drawable.baseline_battery_5_bar_24,
            R.drawable.baseline_battery_6_bar_24,
            R.drawable.baseline_battery_alert_24,
            R.drawable.baseline_battery_charging_full_24,
            R.drawable.baseline_battery_saver_24,
            R.drawable.baseline_battery_unknown_24,
            R.drawable.baseline_battery_alert_24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpobjBat();
    }

    private void setUpobjBat(){
        String[] objBatNames = getResources().getStringArray(R.array.arBatteriesName);

        for (int i = 0; i < objBatNames.length; i++){
            objBat.add(new ObjectBattery(objBatNames[i],imgBatteries[i]));
        }

    }
}