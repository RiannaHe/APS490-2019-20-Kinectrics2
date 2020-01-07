package com.example.capstone_datacollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) toolbar.findViewById(R.id.textView9);
        setSupportActionBar(toolbar);
        //title.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /** Called when the user taps the Send button */
    public void getHistoryData(View view) {
        Intent intent = new Intent(this, getHistoryDataActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void getNewData(View view) {
        Intent intent = new Intent(this, getNewDataActivity.class);
        startActivity(intent);
    }


}
