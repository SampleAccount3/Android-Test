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
    private Button btnExplicit,btnImplicit,btnSearch,btnGetValuesAct2,btnSave,btnNxtPage;
    private EditText edSearch,edValueA,edValueB,edSharedPrefA,edSharedPrefB;
    SharedPreferences sp;
    String strSharedPrefA,strSharedPrefB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSharedPrefA = findViewById(R.id.edSharedpref1);
        edSharedPrefB = findViewById(R.id.edSharedpref2);
        edSearch = findViewById(R.id.edSearch);
        edValueA = findViewById(R.id.edValueA);
        edValueB = findViewById(R.id.edValueB);

        btnImplicit = findViewById(R.id.btnImplicit);
        btnGetValuesAct2 = findViewById(R.id.btnGetValues);
        btnSave = findViewById(R.id.btnSharedPrefSave);
        btnNxtPage = findViewById(R.id.btnNxtPage);
        btnSearch = findViewById(R.id.btnSearch);
//        btnExplicit = findViewById(R.id.btnExplicit);

        btnSearch.setOnClickListener(this);
//        btnExplicit.setOnClickListener(this);
        btnImplicit.setOnClickListener(this);
        btnGetValuesAct2.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnNxtPage.setOnClickListener(this);

        sp = getSharedPreferences("SamplePref", Context.MODE_PRIVATE);


    }


    @Override
    public void onClick(View view) {
        if (R.id.btnImplicit == view.getId()) {
            Toast.makeText(this,"This is a Explicit Intent",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.youtube.com"));
            startActivity(intent);
        }
        if (R.id.btnSearch == view.getId()){
            String url ="https://" + edSearch.getText().toString();
            Toast.makeText(this,"This is a Explicit Intent",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
        if (R.id.btnGetValues == view.getId()){
            String valA = edValueA.getText().toString();
            String valB = edValueB.getText().toString();
            Intent i = new Intent(getApplicationContext(), Activity2.class);
            i.putExtra("ValueA",valA);
            i.putExtra("ValueB",valB);

            startActivity(i);
        }

        if (R.id.btnSharedPrefSave == view.getId()){
            strSharedPrefA = edSharedPrefA.getText().toString();
            strSharedPrefB = edSharedPrefB.getText().toString();

            SharedPreferences.Editor editor = sp.edit();

            editor.putString("ValueA",strSharedPrefA);
            editor.putString("ValueB",strSharedPrefB);
            editor.commit();

            Toast.makeText(this, "Shared Pref Save Success",Toast.LENGTH_SHORT).show();

        }
        if (R.id.btnNxtPage == view.getId()){
            Intent intent = new Intent(MainActivity.this,Activity3.class);

            startActivity(intent);

        }
    }
}