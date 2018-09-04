package com.example.lokajit.settler;

import android.graphics.Path;
import android.os.Environment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class tabs extends AppCompatActivity {
    public EditText editText,dataent;
    public TextView data;

    public Button save,load;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/asettler";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        data=(TextView) findViewById(R.id.data);
        dataent =(EditText)findViewById(R.id.dataent);
        save = (Button) findViewById(R.id.save);
        load = (Button)findViewById(R.id.load);
        File dir=new File(path);
        dir.mkdirs();
    }
    public void buttonsave( View view){
        File file= new File(path + "/savefile.txt");
        String [] savetext= String.valueOf(dataent.getText()).split(System.getProperty("line seperator"));
        dataent.setText("");
        Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
        Save(file,savetext);
    }
    public void buttonload(View view){
        File file=new File(path + "/savefile.txt");
        String []  loadText =Load(file);
        String finalString = "";
        for( int i=0; i<loadText.length ;i++)
        {
            finalString +=loadText[i] + System.getProperty("line seperator");
        }
        data.setText(finalString);
    }

    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }


    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }
}
