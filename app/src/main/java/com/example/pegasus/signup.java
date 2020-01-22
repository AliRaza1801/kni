package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void bu5(View view) {
        EditText ef = findViewById(R.id.username);
        EditText ef1 = findViewById(R.id.password);
        EditText ef2 = findViewById(R.id.confirm_password);
        String a = ef.getText().toString();
        String b = ef1.getText().toString();
        String c = ef2.getText().toString();
        SQLiteDatabase mm = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);
        mm.execSQL("CREATE TABLE IF NOT EXISTS logi(username VARCHAR,password VARCHAR);");
        if (!b.equals(c)) {
            ef2.setError("password not matched");
        }
        else if (a.equalsIgnoreCase("")) {
            ef.setError("please enter any username");
        }
        else if (b.equalsIgnoreCase("")) {
            ef1.setError("please enter any password");
        }
        else {
            Cursor rs = mm.rawQuery("SELECT * FROM logi;", null);
            rs.moveToFirst();
            int x = rs.getCount();
            int n=0;
            while (x != 0) {
                String un = rs.getString(0);
                if (a.equals(un)) {
                    ef.setError("Username already taken");
                    n++;
                    break;

                }
                rs.moveToNext();
                x--;
            }
            if(n==0)
            {
                //mm.execSQL("INSERT INTO logi VALUES(a,b)");
                ContentValues contentValues = new ContentValues();
                contentValues.put("username", a);
                contentValues.put("password", b);
                mm.insert("logi", null, contentValues);
                Toast.makeText(getApplicationContext(), "SIGNUP completed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, login.class);
                startActivity(intent);
            }
        }
    }
        public void bu6 (View view){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
