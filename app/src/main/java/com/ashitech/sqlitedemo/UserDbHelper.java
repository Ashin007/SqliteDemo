package com.ashitech.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashin on 4/2/2018.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_info.db";
    private static final int  DATABASE_VERSION = 1;

    private static  final String CREATE_TABLE = "create table "+UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.USER_NAME+" text,"+UserContract.NewUserInfo.USER_CONTACT
            +" text,"+ UserContract.NewUserInfo.USER_EMAIL+" text);";

    public UserDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        System.out.println("DATABASE"+" "+"DATABASE CREATED");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        System.out.println("DATABASE"+" "+"TABLE CREATED");


    }
    public void addInformation(String userName,String userContact,String userEmail,SQLiteDatabase sqLiteDatabase){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME,userName);
        contentValues.put(UserContract.NewUserInfo.USER_CONTACT,userContact);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,userEmail);
        sqLiteDatabase.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);

        System.out.println("DATABASE"+" "+"DATA ADDED SUCESSFULLY");


    }

    public Cursor getInformation(SQLiteDatabase sqLiteDatabase){


        Cursor cursor;
        String [] projection = {UserContract.NewUserInfo.USER_NAME,UserContract.NewUserInfo.USER_CONTACT,UserContract.NewUserInfo.USER_EMAIL};
        cursor = sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME,projection,null,null,null,null,null);
        return  cursor;
    }

    public Cursor searchContent(String searchName,SQLiteDatabase sqLiteDatabase){
        String[] projection = {UserContract.NewUserInfo.USER_CONTACT,UserContract.NewUserInfo.USER_EMAIL};
        String selection = UserContract.NewUserInfo.USER_NAME+" like ?";
        String [] selection_args = {searchName};
        Cursor cursor = sqLiteDatabase.query(UserContract.NewUserInfo.TABLE_NAME,projection,selection,selection_args,null,null,null);
        return cursor;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
