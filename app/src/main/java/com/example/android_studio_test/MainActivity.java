package com.example.android_studio_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edUsername,edEmail,edAge;
    private Button btnSubmit,btnViewAll;
    private ListView listView;
    private Switch swIsActive;
    DatabaseHelper databaseHelper;
    List<Account> lAllAccount ;
    ArrayAdapter AAAcount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewAccount);

        edUsername = findViewById(R.id.edUserName);
        edEmail = findViewById(R.id.edEmail);
        edAge = findViewById(R.id.edAge);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnViewAll = findViewById(R.id.btnViewAll);
        swIsActive = findViewById(R.id.swIsActive);


        btnSubmit.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Account clickedAccount =(Account) parent.getItemAtPosition(position);
                databaseHelper.DeleteOne(clickedAccount);

                databaseHelper = new DatabaseHelper(MainActivity.this);
                lAllAccount = databaseHelper.getAllTheData();
                AAAcount = new ArrayAdapter<Account>(MainActivity.this, android.R.layout.simple_list_item_1, lAllAccount);
                listView.setAdapter(AAAcount);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (R.id.btnSubmit == v.getId()){
            Account acc;
            try {
                acc = new Account(-1, edUsername.getText().toString(), edEmail.getText().toString(), Integer.parseInt(edAge.getText().toString()), swIsActive.isChecked());
            }catch (Exception e){
                Toast.makeText(MainActivity.this, "Please make sure that you add a value on age: " + e, Toast.LENGTH_SHORT).show();
                acc = new Account(-1, "error", "error", 0, false);
            }
            DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
            final boolean Success = databaseHelper.addOne(acc);
//            Toast.makeText(this, "Success?" + Success, Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, acc.toString(), Toast.LENGTH_SHORT).show();
            ShowDatabase(databaseHelper);
        }
        if (R.id.btnViewAll == v.getId()){
            databaseHelper = new DatabaseHelper(MainActivity.this);
            lAllAccount = databaseHelper.getAllTheData();
            ShowDatabase(databaseHelper);

//            Toast.makeText(MainActivity.this, lAllAccount.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ShowDatabase(DatabaseHelper databaseHelper1){
        AAAcount = new ArrayAdapter<Account>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper1.getAllTheData());
        listView.setAdapter(AAAcount);
    }



}
