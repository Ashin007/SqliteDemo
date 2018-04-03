package com.ashitech.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    EditText etName,etContactNumber,etEmail;
    Context context = this;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;

    public void btnSaveData(View view){

        String userName = etName.getText().toString();
        String userContact = etContactNumber.getText().toString();
        String userEmail = etEmail.getText().toString();

        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(userName,userContact,userEmail,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),"Data added sucessfully",Toast.LENGTH_SHORT).show();
        userDbHelper.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        etName = findViewById(R.id.etName);
        etContactNumber = findViewById(R.id.etContactNumber);
        etEmail = findViewById(R.id.etEmail);
    }
}
