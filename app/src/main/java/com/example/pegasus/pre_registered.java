package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class pre_registered extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_registered);
        Intent intent = getIntent();
        String u = intent.getStringExtra("extra_12");
        SQLiteDatabase ml = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);
        Cursor rs = ml.rawQuery("SELECT * FROM pool;", null);
        rs.moveToFirst();
        int x = rs.getCount();
        int c = 0;
        while (x != 0) {
            String d = rs.getString(0);
            if (u.equals(d)) {
                c++;
                break;
            }
            x--;
            rs.moveToNext();
        }
            ImageView imv=findViewById(R.id.imageView4);
            String s=rs.getString(7);
            Uri h=Uri.parse(s);
            imv.setImageURI(h);
            String es1 = rs.getString(1);
            TextView textview = findViewById(R.id.ttt1);
            textview.setText(es1);
            String es2 = rs.getString(2);
            TextView textview1 = findViewById(R.id.ttt2);
            textview1.setText(es2);
            String es3 = rs.getString(3);
            TextView textview2 = findViewById(R.id.ttt4);
            textview2.setText(es3);
            String es4 = rs.getString(4);
            TextView textview3 = findViewById(R.id.ttt5);
            textview3.setText(es4);
            String es5 = rs.getString(5);
            TextView textview4 = findViewById(R.id.ttt6);
            textview4.setText(es5);
            String es6 = rs.getString(6);
            TextView textview5 = findViewById(R.id.ttt7);
            textview5.setText(es6);
    }
    public void bu12(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
