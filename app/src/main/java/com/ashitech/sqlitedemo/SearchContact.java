package com.ashitech.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchContact extends AppCompatActivity {

    EditText etSearchName;
    Button btnSearch;
    TextView tvContactFeild,tvEmailFeild;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        etSearchName = findViewById(R.id.etSearchName);
        btnSearch = findViewById(R.id.btnSearch);
        tvContactFeild = findViewById(R.id.tvContactFeild);
        tvEmailFeild = findViewById(R.id.tvEmailFeild);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String searchName = etSearchName.getText().toString();
               userDbHelper = new UserDbHelper(getApplicationContext());
               sqLiteDatabase = userDbHelper.getReadableDatabase();
               cursor = userDbHelper.searchContent(searchName,sqLiteDatabase);
              if(cursor.moveToFirst()){
                  String contact = cursor.getString(0);
                  String email = cursor.getString(1);

                  tvContactFeild.setText(contact);
                  tvEmailFeild.setText(email);
              }
            }
        });
    }
}
