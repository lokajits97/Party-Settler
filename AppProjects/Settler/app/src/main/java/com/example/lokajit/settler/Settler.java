package com.example.lokajit.settler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settler extends AppCompatActivity {

    public Button butptp;
    public void tobegin(){
        butptp = (Button)findViewById(R.id.butptp);
        butptp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent toy=new Intent(Settler.this,Payment.class);
                startActivity(toy);
            }
        });
    }

    public Button buttab;
    public void totab(){
        buttab = (Button)findViewById(R.id.buttab);
        buttab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent toy3=new Intent(Settler.this,tabs.class);
                startActivity(toy3);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settler);
        tobegin();totab();

    }

}
