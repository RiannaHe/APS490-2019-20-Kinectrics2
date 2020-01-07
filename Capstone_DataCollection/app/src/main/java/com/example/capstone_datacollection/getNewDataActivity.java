package com.example.capstone_datacollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class getNewDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_new_data);
        setTitle("Get New Data");

    }

    // bluetooth connection

    // bluetooth connection successfully -> show either highlight or pop-up notification

    // jump to display temporary data

    public void StoreData1() {

        // Use Activity method to create a file in the writeable directory
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("filename1", Context.MODE_PRIVATE);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        // Create buffered writer
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        try {
            writer.write("Hi, I'm writing stuff......");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void StoreData2() {

        // Use Activity method to create a file in the writeable directory
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("filename2", Context.MODE_PRIVATE);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        // Create buffered writer
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        try {
            writer.write("yeah");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void station1(View view) {
        StoreData1();
        Intent intent = new Intent(this, displayNewGetData.class);
        intent.putExtra("STATION_NAME", "01");
        startActivity(intent);
    }

    public void station2(View view) {
        StoreData2();
        Intent intent = new Intent(this, displayNewGetData.class);
        intent.putExtra("STATION_NAME", "02");
        startActivity(intent);
    }

}
