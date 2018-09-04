package com.example.lokajit.settler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Payment extends AppCompatActivity {
    public double result=0;

    public void calchange() {
        Button changeb = (Button) findViewById(R.id.changeb);
        changeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent toy1= new Intent(Payment.this, changecal.class);
                toy1.putExtra("doubleValue_e1", result);
                startActivity(toy1);
            }
        });
    }




    public Button vatc;
    public void calvat(){
        vatc= (Button)findViewById(R.id.vatc);
        vatc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent toy=new Intent(Payment.this,vatcal.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        calvat(); calchange();
    }
    public void calculate(View v){
        EditText input = (EditText) findViewById(R.id.amount);
        TextView output=(TextView) findViewById(R.id.tvOutput);
        double base =Double.valueOf(input.getText().toString());
        double temp = (base + ((base * 125) / 1000));
         result = (temp + temp * 5/100);
        String formattedResult = String.format("%,f ",(result));
        output.setText(" "+ formattedResult +" INR" );
    }
}
