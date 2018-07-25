package com.example.student.potatocorner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBTools extends SQLiteOpenHelper
{

    public DBTools(Context context) {
        super(context, "RegDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String query = "CREATE TABLE tblUsers (UserID INTEGER PRIMARY KEY AUTOINCREMENT,UsernameRegistration TEXT, PasswordRegistration TEXT, FirstName TEXT, LastName TEXT, ContactNumber TEXT, Email TEXT) ";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS tblUsers";
        sqLiteDatabase.execSQL(query);
    }

    public List<String> getAllUsers(){

        List<String> customerArrayList = new ArrayList<String>();
        String selectQuery = "SELECT UserName FROM tblUsers";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                customerArrayList.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        database.close();
        return customerArrayList;
    }

    public HashMap<String, String> getUsers(int userID){

        HashMap<String, String> customerMap = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tblUsers WHERE UserID = " + userID;
        Cursor cursor = database.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                customerMap.put("UserID", cursor.getString(0));
                customerMap.put("UserName",cursor.getString(1));
            }while(cursor.moveToNext());
        }
        database.close();
        return customerMap;
    }

    public HashMap<String, String> getUserByUserNamePassword(String username, String password){

        HashMap<String, String> customerMap = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM tblUsers WHERE UsernameRegistration  = '" + username + "' AND PasswordRegistration = '" + password + "'";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                customerMap.put("UserID", cursor.getString(0));
                customerMap.put("UserName",cursor.getString(1));
                customerMap.put("PhoneNo", cursor.getString(2));
                Log.e("UserID",cursor.getString(0));
                Log.e("UserID",cursor.getString(1));
                Log.e("UserID",cursor.getString(2));

            }while(cursor.moveToNext());
        }
        database.close();
        return customerMap;
    }

    public int insertCustomer(HashMap<String, String> queryValues){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("UsernameRegistration",queryValues.get("UsernameRegistration"));
        values.put("PasswordRegistration",queryValues.get("PasswordRegistration"));
        values.put("FirstName",queryValues.get("FirstName"));
        values.put("LastName",queryValues.get("LastName"));
        values.put("ContactNumber",queryValues.get("ContactNumber"));
        values.put("Email",queryValues.get("Email"));

        int success = (int) database.insert("tblUsers", null, values);
        database.close();
        return success;
    }
}
