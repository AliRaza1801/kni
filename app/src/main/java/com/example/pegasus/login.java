package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void bbu8(View view){
        Intent intent=new Intent(login.this,MainActivity.class);
        startActivity(intent);
    }
    public void bbd4(View view){
        EditText en=findViewById(R.id.username);
        EditText en1=findViewById(R.id.password);
        String a=en.getText().toString();
        String b=en1.getText().toString();
        SQLiteDatabase md=openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);
        if(a.equalsIgnoreCase(""))
        {
            en.setError("please enter any username");
        }
        else if(b.equalsIgnoreCase(""))
        {
            en1.setError("please enter any password");
        }
        else
            {
                    Cursor rs = md.rawQuery("SELECT * FROM logi;", null);
                    rs.moveToFirst();
                    int x = rs.getCount();
                    int c = 0;
                    while (x != 0) {
                        String un = rs.getString(0);
                        String ps = rs.getString(1);
                        if (a.equals(un) && b.equals(ps)) {
                            Cursor r = md.rawQuery("SELECT * FROM pool;", null);
                            r.moveToFirst();
                            int m = r.getCount();
                            int n = 0;
                            while (m != 0) {
                                String j = r.getString(0);
                                if (a.equals(j)) {
                                    n++;
                                    Toast.makeText(getApplicationContext(), "already registered", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(this, midphase.class);
                                    intent.putExtra("extra_15", a);
                                    startActivity(intent);
                                }
                                r.moveToNext();
                                m--;
                            }
                            if (n == 0) {
                                Intent intent = new Intent(this, detail.class);
                                intent.putExtra("extra_8", a);
                                startActivity(intent);
                                c++;
                            }
                        }
                        else if ((!b.equals(ps)) && a.equals(un)) {
                            en1.setError("Wrong Password");
                            c++;
                        }
                        rs.moveToNext();
                        x--;
                    }
                    if (c == 0) {
                        Toast.makeText(getApplicationContext(), "SIGNUP FIRST", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    }
