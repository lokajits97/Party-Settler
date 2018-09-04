package com.example.lokajit.settler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class vatcal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vatcal);
    }
    public void calculate(View v){
        EditText input1 = (EditText) findViewById(R.id.vat);
        EditText input2 = (EditText) findViewById(R.id.total);

        TextView output=(TextView) findViewById(R.id.vatperc);
        int vatamt =Integer.valueOf(input1.getText().toString());
        int totalamt =Integer.valueOf(input2.getText().toString());

        float result = (float)(vatamt*100)/totalamt;
        String formattedResult = String.format("%,f ",(result));
        output.setText(" "+ formattedResult +"%" );
    }
}
