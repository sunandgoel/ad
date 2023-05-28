package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME="example.txt";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextText1);

    }

    public void Save(View view) {
        String text=editText.getText().toString();
        FileOutputStream fos=null;
        try {
            fos=openFileOutput("FILE_NAME",MODE_PRIVATE);
            fos.write(text.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void Load(View view) {
        String Text;
        FileInputStream fis=null;
        try {
            fis=openFileInput("FILE_NAME");
            InputStreamReader inputStreamReader=new InputStreamReader(fis);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder=new StringBuilder();

            while((Text=bufferedReader.readLine())!=null)
                stringBuilder.append(Text).append("\n");
            editText.setText(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fis!=null){
                try {
                    fis.close();
                    fis=null;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}