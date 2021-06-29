package com.egovictoria.savingthingsintextfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;

public class ViewDictionary extends AppCompatActivity {

    private static final String TAG = "STITF/viewdict";
    private ListView dictList;
    private Button toMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dictionary);


        Log.i(TAG, "onCreate: current dictionary file: \n " + AppConstants.dict.getFile());

        dictList = findViewById(R.id.viewDictionaryListView);
        toMain = findViewById(R.id.toMainMenuFromViewDictionary);

        Log.i(TAG, "onCreate: views initialized");
        Log.i(TAG, "onCreate: creating custom array adapter with the following array:\n"
                + AppConstants.dict.getTags());

        try {

            DictionaryAdapter adapter = new DictionaryAdapter(
                    this,
                    R.layout.dictionary_list_adapter,
                    AppConstants.dict.getTags());

            Log.i(TAG, "onCreate: adapter created successfully");
            dictList.setAdapter(adapter);
            Log.i(TAG, "onCreate: adapter set");
        } catch (Exception e) {
            e.printStackTrace();
            Log.i(TAG, "onCreate: error setting adapter " + e.getClass().getCanonicalName());
        }

        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewDictionary.this, MainActivity.class));
                finish();
            }
        });

        Log.i(TAG, "onCreate: on click listener set");
    }
}