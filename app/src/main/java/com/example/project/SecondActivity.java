package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.R;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    TextView prefTextRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Get a reference to the shared preference
        myPreferenceRef = getSharedPreferences("MyPreferencesName", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        Button close = findViewById(R.id.closeSecondActivity);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void savePref(View view){
        // Get the text
        EditText newPrefText = new EditText(this);
        newPrefText = (EditText)findViewById(R.id.settingseditview);

        // Store the new preference
        myPreferenceEditor.putString("MyAppPreferenceString", newPrefText.getText().toString());
        myPreferenceEditor.apply();

        newPrefText.setText("");
    }

}