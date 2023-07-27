package com.example.budgetmanagerapp;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseHelper {
    String TABLE_NAME = ;

    void onCreate();

    SQLiteDatabase getWritableDatabase();
}
