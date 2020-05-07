package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText input;
    EditText output;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        //this.write();

    }

//    public void HelloWorld(View v) {
//        System.out.println("Hello world!");
//        text.setText(etext.getText().toString());
//    }
//




    public void writeFile(View v){
        EditText input;
        EditText output;
        input = findViewById(R.id.editText);
        output = findViewById(R.id.editText2);
        try{
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(input.getText().toString(),Context.MODE_PRIVATE));
            ows.write(output.getText().toString());
            ows.close();
        } catch (IOException e){
            Log.e("IOException", "Virhe lukiessa");
        }

    }
    public void readFile(View v){
        EditText input;
        EditText output;
        input = findViewById(R.id.editText);
        output = findViewById(R.id.editText2);
        try{
            InputStream ins = context.openFileInput(input.getText().toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String a = "";
            String story = "";

            while ((a=br.readLine())!= null){
                story = story + a + "\n";
            }
            output.setText(story);
            ins.close();

        } catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");

        }
    }

}
