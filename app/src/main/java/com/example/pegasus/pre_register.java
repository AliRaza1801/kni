package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class pre_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_register);
    }
    public void bu9(View view){
        EditText ee=findViewById(R.id.ee1);
        String a=ee.getText().toString();
        if(a.equalsIgnoreCase(""))
        {
            ee.setError("Enter username");
        }
        else {
            SQLiteDatabase ml=openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);
            Cursor rs=ml.rawQuery("SELECT * FROM pool;",null);
            rs.moveToFirst();
            int x=rs.getCount();
            int c=0;
            while(x!=0) {
                String j = rs.getString(0);
                if (a.equals(j)) {
                    c++;
                    Intent intent = new Intent(this, pre_registered.class);
                    intent.putExtra("extra_12",a);
                    startActivity(intent);
                }
                rs.moveToNext();
                x--;
            }
            if(c==0) {
                Toast.makeText(getApplicationContext(), "Register First", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
