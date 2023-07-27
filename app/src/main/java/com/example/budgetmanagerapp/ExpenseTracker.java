package com.example.budgetmanagerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ExpenseTracker {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper = () -> {

    };
    private String TABLE_NAME;

    public ExpenseTracker(Context context) {
        db = dbHelper.getWritableDatabase();
    }

    public boolean insertExpense(String category, int amount, String date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, category);
        contentValues.put(DatabaseHelper.COL_3, amount);
        contentValues.put(DatabaseHelper.COL_4, date);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getExpenses() {
        return db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);
    }

    private class TABLE_NAME {
    }
}
