package com.egovictoria.savingthingsintextfiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    /*
    PROJECT FAILED SINCE APP CAN NEVER HAVE WRITE PERMISSIONS TO INTERNAL DIRECTORY, WILL FINISH THIS
    ONCE PROPER PERMISSIONS AND TIME CAN BE SPENT ADDING THE PROPER FILE DIRECTORIES TO THE SAVE PATH
     */

    private Button toAddItem, toViewDict, wipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // appConstants
        try {
            AppConstants.initialize(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // initialize views
        toAddItem = findViewById(R.id.toAddItemFromMain);
        toViewDict = findViewById(R.id.toViewDictionaryFromMainMenu);
        wipe = findViewById(R.id.mainMenuWipeDBButton);


        // set on click listeners
        toAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
                finish();
            }
        });
        toViewDict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewDictionary.class));
                finish();
            }
        });
        wipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AppConstants.dict.clearFile();
                    Toast.makeText(getApplicationContext(), "Dictionary set to blank", Toast.LENGTH_SHORT).show();
            }
        });
    }
}