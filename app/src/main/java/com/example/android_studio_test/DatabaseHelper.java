package com.example.android_studio_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COLUMN_ID = "ID";
    public static final String ACCOUNT_TABLE = "ACCOUNT_TABLE";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_EMAIL = "EMAILADDRESS";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_IS_ACTIVE = "ISACTIVE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableStatement = "CREATE TABLE " +
                ACCOUNT_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_AGE + " INT," +
                COLUMN_IS_ACTIVE + " BOOL)";
        sqLiteDatabase.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        System.out.println("Upgrading database from version " + oldVersion + " to " + newVersion);
    }


    public boolean addOne(Account acc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME,acc.getUserName());
        cv.put(COLUMN_EMAIL,acc.getEmail());
        cv.put(COLUMN_AGE,acc.getAge());
        cv.put(COLUMN_IS_ACTIVE,acc.isActive());
        long insert = db.insert(ACCOUNT_TABLE,null, cv);

        return insert != -1;
    }

    public boolean DeleteOne(Account acc){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ACCOUNT_TABLE + " WHERE " + COLUMN_ID + " = " + acc.getID();
        final Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst())return true;
        else return false;
    }

    public List<Account> getAllTheData(){
        List<Account> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + ACCOUNT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);

        if (cursor.moveToNext()){
            do {
                int accID = cursor.getInt(0);
                String userName = cursor.getString(1);
                String userEmail = cursor.getString(2);
                int userAge = cursor.getInt(3);
                Boolean userIsActive = cursor.getInt(3) ==1 ? true:false;
                Account newAccount = new Account(accID, userName, userEmail, userAge, userIsActive);

                returnList.add(newAccount);

            }while (cursor.moveToNext());
        }else {}

        cursor.close();
        db.close();
        return returnList;
    }
}
