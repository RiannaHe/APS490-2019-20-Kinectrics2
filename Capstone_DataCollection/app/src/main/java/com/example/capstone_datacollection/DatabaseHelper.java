package com.example.capstone_datacollection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CollectedData.db";
    public static final String TABLE_NAME = "Data_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "STATION_NO";
    public static final String COL_3 = "DATE";
    public static final String COL_4 = "DATA_VALUE_1";
    public static final String COL_5 = "DATA_VALUE_2";
    public static final String COL_6 = "DATA_VALUE_3";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("Mytag", "Creating Helper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,STATION_NO TEXT,DATE TEXT,DATA_VALUE_1 TEXT,DATA_VALUE_2 TEXT,DATA_VALUE_3 TEXT)");
    Log.d("Mytag", "Creating table");
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
//    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String STATION_NO, String DATE, String DATA_VALUE_1, String DATA_VALUE_2, String DATA_VALUE_3) {
        SQLiteDatabase db = this.getWritableDatabase();

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_1, ID);
        contentValues.put(COL_2, STATION_NO);
        contentValues.put(COL_3, DATE);
        contentValues.put(COL_4, DATA_VALUE_1);
        contentValues.put(COL_5, DATA_VALUE_2);
        contentValues.put(COL_6, DATA_VALUE_3);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getStationData(String station) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME +
                " where " + COL_2 + "=\"" + station + "\"", null);
        return res;
    }

    // Example usage:
    // db.executeSQL("select * from table where this = that, AND ...");
    public Cursor executeSQL(String sql_statement) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(sql_statement, null);
        return res;
    }

    public Cursor getStation1AllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + "where " + COL_2 + "=\"01\"", null);
        return res;
    }

    public Cursor getStation2AllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + "where " + COL_2 + "=\"02\"", null);
        return res;
    }
}