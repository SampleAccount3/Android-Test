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

//        Android resolves intents based on the named component, action, type of data, and categories specified in the
//        intent. It compares the contents of the intent with the intent filters in each app’s AndroidManifest.xml. An activity
//        must have a category of DEFAULT if it is to receive an implicit intent.

        // Anonymous Function Onclick
        btnSendData.setOnClickListener(view -> {
            Toast.makeText(this, "Sample", Toast.LENGTH_SHORT).show();
            DataToPass = edData.getText().toString();
            //The commented intent is explicit it is uses to pass the data to other Target activities
//            Intent intent = new  Intent(this,ActivityNew.class);
//            intent.putExtra(ActivityNew.MESSAGE_RECEIVED,DataToPass);

            //ACTION_SEND can be use to send your data to other apps that has an ACTION_SEND activities
            Intent intent = new Intent(Intent.ACTION_SEND);
            //setType describes the data type of the intent data
            intent.setType("text/plain");
            //putExtra method to add extra information to the intent
            intent.putExtra(Intent.EXTRA_TEXT,DataToPass);
            //Gets the string in Strings.xml
            String chooserTitle = getString(R.string.chooser);

            //chosen intent disables the always choose button when picking an app
            Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
            startActivity(chosenIntent);
        });

    }
}