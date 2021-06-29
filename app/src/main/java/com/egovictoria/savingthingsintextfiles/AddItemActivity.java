package com.egovictoria.savingthingsintextfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;

public class AddItemActivity extends AppCompatActivity {

    private EditText ETTag, ETDetails;
    private Button confirm, menu;
    private static final String TAG = "STITF/addItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        // initialize dictionary

        // initialize views
        ETTag = findViewById(R.id.ETTag);
        ETDetails = findViewById(R.id.ETDetails);
        confirm = findViewById(R.id.confirmItemToBeAdded);
        menu = findViewById(R.id.toMainMenuFromAddItem);

        // tag can take any string input of any length, initially set ETDetails to not accept entry
        ETTag.setInputType(InputType.TYPE_CLASS_TEXT);
        ETDetails.setInputType(InputType.TYPE_CLASS_TEXT);

        // on item click listeners
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ETTag.getText().toString().equals("") && !ETDetails.getText().toString().equals("")){
                    Log.i(TAG, "attempting to add item to dictionary");
                        AppConstants.dict.addItem(ETTag.getText().toString(), ETDetails.getText().toString());
                        Toast.makeText(getApplicationContext(), "item added to dictionary",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddItemActivity.this, MainActivity.class));
                finish();
            }
        });

        Log.i(TAG, "add item activity loaded");
    }
}
