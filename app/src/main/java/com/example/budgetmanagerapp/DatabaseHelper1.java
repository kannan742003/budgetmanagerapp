package com.example.budgetmanagerapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper1 extends SQLiteOpenHelper implements DatabaseHelper {

    public static final String DATABASE_NAME = "BudgetManager.db";
    public static final String TABLE_NAME = "expenses";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CATEGORY";
    public static final String COL_3 = "AMOUNT";
    public static final String COL_4 = "DATE";
    private SQLiteDatabase db;

    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate() {
        onCreate(null);
    }

    /**
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORY TEXT, AMOUNT INTEGER, DATE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}

