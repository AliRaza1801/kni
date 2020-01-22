package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FORM extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Intent intent=getIntent();
        String es1=intent.getStringExtra("extra_1");
        TextView textview=findViewById(R.id.t1);
        textview.setText(es1);
        String es2=intent.getStringExtra("extra_2");
        TextView textview1=findViewById(R.id.t2);
        textview1.setText(es2);
        String es3=intent.getStringExtra("extra_3");
        TextView textview2=findViewById(R.id.t4);
        textview2.setText(es3);
        String es4=intent.getStringExtra("extra_4");
        TextView textview3=findViewById(R.id.t5);
        textview3.setText(es4);
        String es5=intent.getStringExtra("extra_5");
        TextView textview4=findViewById(R.id.t6);
        textview4.setText(es5);
        String es6=intent.getStringExtra("extra_6");
        TextView textview5=findViewById(R.id.t7);
        textview5.setText(es6);
        ImageView imageView=findViewById(R.id.imageView3);
        String es7=intent.getStringExtra("extra_i");
        Uri p=Uri.parse(es7);
        imageView.setImageURI(p);

    }
    public void bu11(View view)
    {
        SQLiteDatabase mm=openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);
        Intent intent=getIntent();
        String em=intent.getStringExtra("extra_10");
        String em1=intent.getStringExtra("extra_1");
        String em2=intent.getStringExtra("extra_2");
        String em3=intent.getStringExtra("extra_3");
        String em4=intent.getStringExtra("extra_4");
        String em5=intent.getStringExtra("extra_5");
        String em6=intent.getStringExtra("extra_6");
        ContentValues con = new ContentValues();
        con.put("usern", em);
        con.put("name", em1);
        con.put("rollno", em2);
        con.put("age", em3);
        con.put("email", em4);
        con.put("dob", em5);
        con.put("phoneno", em6);
        String s = intent.getStringExtra("extra_i");
        con.put("image", s);
        mm.insert("pool", null, con);
        Toast.makeText(getApplicationContext(), "YOU ARE REGISTERED", Toast.LENGTH_SHORT).show();
        Intent inte = new Intent(this, thanq.class);
        startActivity(inte);
    }
}


