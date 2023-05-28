package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitHandler(View view){
        EditText fname = findViewById(R.id.editTextFirstName);
        EditText lname = findViewById(R.id.editTextLastName);
        EditText email = findViewById(R.id.editTextEmail);
        TextView f = findViewById(R.id.textViewFN);
        TextView l = findViewById(R.id.textView2LN);
        TextView e = findViewById(R.id.textView3EA);
        f.setText(fname.getText().toString());
        l.setText(lname.getText().toString());
        e.setText(email.getText().toString());
    }
}

