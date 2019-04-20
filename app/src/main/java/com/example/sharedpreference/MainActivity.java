package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText nameField;
    SharedPreferences sharedPreferences;



    public void submitName(View view) {
        String name = nameField.getText().toString();
        sharedPreferences.edit().putString("Name", name).apply();
        Toast.makeText(this, "Name is set to " + sharedPreferences.getString("Name", ""), Toast.LENGTH_LONG).show();

    }

    public void reset(View view){
        nameField.setText(sharedPreferences.getString("Name", "ABCD"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.editText);

        sharedPreferences = this.getSharedPreferences("com.example.sharedpreference", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("default", "Moksh").apply();
    }
}
