package com.example.capstone_datacollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



// display data from temporary space
// save data into DB

public class displayNewGetData extends AppCompatActivity {

    public static final String S1 = "20";
    public static final String S2 = "50";
    public static final String S3 = "100";

    public static final String S4 = "X";
    public static final String S5 = "Y";
    public static final String S6 = "Z";

    Button btnAddData;
    DatabaseHelper myDb;
    String MyStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_new_get_data);
        btnAddData = findViewById(R.id.add_button);
        myDb = new DatabaseHelper(this);
        MyStation = getIntent().getStringExtra("STATION_NAME");
        setTitle(MyStation.equals("01") ? "Station 1" : "Station 2");
        saveToDB();

        tempDisplay();
    }


    public void tempDisplay() {
        TextView textView = findViewById(R.id.textView);
        textView.setText(S1);

        TextView textView2 = findViewById(R.id.textView5);
        textView2.setText(S2);

        TextView textView3 = findViewById(R.id.textView7);
        textView3.setText(S3);

    }

    public void saveToDB() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //boolean isInserted = myDb.insertData("01", "2019", S1, S2, S3);
                        if (MyStation.equals("01")) {
                            boolean isInserted = myDb.insertData(MyStation, "2019", S1, S2, S3);
                            if (isInserted == true)
                                Toast.makeText(displayNewGetData.this, "S1 Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(displayNewGetData.this, "S1 Data not Inserted", Toast.LENGTH_LONG).show();
                        } else if (MyStation.equals("02")){

                            boolean isInserted2 = myDb.insertData(MyStation, "2019", S4, S5, S6);
                            if (isInserted2 == true)
                                Toast.makeText(displayNewGetData.this, "S2 Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(displayNewGetData.this, "S2 Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }


                }
        );

//        public void saveToDB(View view){
//        myDb = new DatabaseHelper(this);
//        myDb.insertData( "01", "2019", S1, S2, S3);
//    }


    }
}





//    String filename = getIntent().getStringExtra("FILENAME");


 /*       BufferedReader input = null;
        try {
            input = new BufferedReader(
                    new InputStreamReader(openFileInput(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        StringBuffer buffer = new StringBuffer();
        while (true) {
            try {
                if (!((line = input.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.append(line + "\n");
        }
        String text = buffer.toString();
*/


// Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView2);
//        textView.setText(text);