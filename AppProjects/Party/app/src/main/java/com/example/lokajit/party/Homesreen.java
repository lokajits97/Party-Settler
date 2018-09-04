package com.example.lokajit.party;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Homesreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homesreen);
    }

    public void calculate(View v){
        EditText input = (EditText) findViewById(R.id.amount);
        TextView output=(TextView) findViewById(R.id.tvOutput);
        double base =Double.valueOf(input.getText().toString());
      double temp = (base + ((base * 125) / 1000));
        double result = (temp + temp * 5/100);
        String formattedResult = String.format("%,f ",(result));
        output.setText(" "+ formattedResult +" INR" );
    }
}
