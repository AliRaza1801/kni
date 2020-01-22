package com.example.pegasus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public static final String DATABASE_NAME = "knit";
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createEmployeeTable();

    }
    private void createEmployeeTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS pool (\n" +
                        "    usern varchar(200) NOT NULL,\n"+
                        "    name varchar(200) NOT NULL,\n" +
                        "    rollno INTEGER NOT NULL,\n" +
                        "    age INTEGER NOT NULL,\n" +
                        "    email varchar(200) NOT NULL,\n" +
                        "    dob varchar(200) NOT NULL,\n"+
                        "    phoneno INTEGER NOT NULL,\n"+
                        "    image varchar(200) NOT NULL \n"+
                        ");"
        );
    }

    public void bu1(View view){
        Intent intent=new Intent(MainActivity.this,login.class);
        startActivity(intent);
    }
    public void bu2(View view){
        Intent intent=new Intent(MainActivity.this,signup.class);
        startActivity(intent);
    }
    public void bu3(View view){
        Intent intent=new Intent(this,pre_register.class);
        startActivity(intent);
    }
    public void admin1(View view){startActivity(new Intent(this,admin.class));
    }

}
