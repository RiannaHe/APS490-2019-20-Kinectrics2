package com.example.capstone_datacollection;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class displayHistoryData extends AppCompatActivity {
    DatabaseHelper myDb;
    String MyStation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history_data);
        myDb = new DatabaseHelper(this);
        MyStation = getIntent().getStringExtra("STATION_NAME");
        // Capture the layout's TextView and set the string as its text
        displayData();
        setTitle(MyStation.equals("01") ? "Station 1" : "Station 2");
    }

    public void displayData()
    {

        //Cursor cursor = myDb.getAllData();
        Cursor cursor = myDb.getStationData(MyStation);
        TextView Data1 = findViewById(R.id.textView),
                Data2 = findViewById(R.id.textView5),
                Data3 = findViewById(R.id.textView7);
        if (cursor.getCount() == 0) {
            Toast.makeText(displayHistoryData.this, "nothing", Toast.LENGTH_LONG).show();
            Data1.setText("Nothing to show");
        }
        String D1 = "", D2 = "", D3 = "";
        while(cursor.moveToNext()) {
            D1 = cursor.getString(3);
            D2 = cursor.getString(4);
            D3 = cursor.getString(5);
        }
        Data1.setText(D1);
        Data2.setText(D2);
        Data3.setText(D3);
    }
}
//        String filename = getIntent().getStringExtra("FILENAME");
//        BufferedReader input = null;
//        try {
//            input = new BufferedReader(
//                    new InputStreamReader(openFileInput(filename)));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String line = "";
//        StringBuffer buffer = new StringBuffer();
//        while (true) {
//            try {
//                if (!((line = input.readLine()) != null)) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            buffer.append(line + "\n");
//        }
//        String text = buffer.toString();