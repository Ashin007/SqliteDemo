package com.ashitech.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ContactView extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyleViewAdapter;
    ArrayList<ContactInfo>arrayList = new ArrayList<>();

    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;

    String name,contact,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);
        recyclerView = findViewById(R.id.rv_contact_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(ContactView.this));
        recyclerView.setHasFixedSize(true);
        userDbHelper = new UserDbHelper(this);
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.getInformation(sqLiteDatabase);
        if(cursor.moveToFirst()){
            do{

                name = cursor.getString(0);
                contact = cursor.getString(1);
                email = cursor.getString(2);



                arrayList.add(new ContactInfo(name,contact,email));
            }
            while (cursor.moveToNext());
        }


        recyleViewAdapter = new RecycleAdapter(arrayList);
        recyclerView.setAdapter(recyleViewAdapter);


    }
}
