package com.example.lokajit.settler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class changecal extends AppCompatActivity {

     double e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changecal);

        Intent receiveIntent = this.getIntent();
        e1 = receiveIntent.getDoubleExtra("doubleValue_e1", 0 );
    }


    public void calculate(View v){
        EditText paid = (EditText) findViewById(R.id.paid);
        TextView output=(TextView) findViewById(R.id.change);
        double amtpaid =Double.valueOf(paid.getText().toString());
        double amtchange = amtpaid - e1;

        String formattedResult = String.format("%,f ",(amtchange));
        output.setText(" "+ formattedResult +" INR" );
    }
}
