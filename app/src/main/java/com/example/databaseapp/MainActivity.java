package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editNote;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = findViewById(R.id.textView);
         editNote = findViewById(R.id.editNote);
         button = findViewById(R.id.button);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String msg = editNote.getText().toString();
                 SharedPreferences sharedPreferences = getSharedPreferences("demo",MODE_PRIVATE);
                 SharedPreferences.Editor editor = sharedPreferences.edit();
                 editor.putString("value",msg);
                 editor.apply();
                 textView.setText(msg);
             }
         });

         SharedPreferences sharedPreferences = getSharedPreferences("demo",MODE_PRIVATE);
         String value = sharedPreferences.getString("value","Type a note to save it");
         textView.setText(value);

    }
}