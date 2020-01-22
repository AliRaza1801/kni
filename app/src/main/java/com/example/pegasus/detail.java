package com.example.pegasus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Calendar;

public class detail extends AppCompatActivity {
    final static int pickimg=100;
    Button button;
    ImageView image;
    Uri imageUri;
    EditText ett;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ett=findViewById(R.id.e5);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        ett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(detail.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                ett.setText(date);
            }
        };
        image=(ImageView)findViewById(R.id.imageView2);
        button=(Button)findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengallery();
            }
        });

    }
    public void opengallery()
    {
        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i,pickimg);
    }
    @Override
    public void onActivityResult(int Requestcode,int Resultcode,Intent data){
        super.onActivityResult(Requestcode,Resultcode,data);
        if (Resultcode==RESULT_OK&&Requestcode==pickimg){
            imageUri=data.getData();
            image.setImageURI(imageUri);
        }
    }
    public void txttc(View view)
    {
        EditText ee1=findViewById(R.id.e1);
        EditText ee2=findViewById(R.id.e2);
        EditText ee3=findViewById(R.id.e3);
        EditText ee4=findViewById(R.id.e4);
        EditText ee5=findViewById(R.id.e5);
        EditText ee6=findViewById(R.id.e6);
        ImageView ee7=findViewById(R.id.imageView2);
        String a=ee1.getText().toString();
        String b=ee2.getText().toString();
        String c=ee3.getText().toString();
        String d=ee4.getText().toString();
        String e=ee5.getText().toString();
        String f=ee6.getText().toString();
        String g=imageUri.toString();
        if(a.equalsIgnoreCase(""))
        {
            ee1.setError("please give your name");
        }
        else if(b.equalsIgnoreCase("")||b.length()!=6)
        {
            ee2.setError("please give your Roll number");
            Toast.makeText(getApplicationContext(),"roll number missing", Toast.LENGTH_SHORT).show();
        }
        else if(c.equalsIgnoreCase("")||c.length()>2)
        {
            ee3.setError("please give your Age");
            Toast.makeText(getApplicationContext(),"AGE missing", Toast.LENGTH_SHORT).show();
        }
        else if(d.equalsIgnoreCase("")||!d.contains("@")||!d.contains(".com")||d.length()>20)
        {
            ee4.setError("please give your E-mail");
            Toast.makeText(getApplicationContext(),"E-mail missing", Toast.LENGTH_SHORT).show();
        }
        else if(e.equalsIgnoreCase(""))
        {
            ee5.setError("please give your Date of birth");
            Toast.makeText(getApplicationContext(),"DOB missing", Toast.LENGTH_SHORT).show();
        }
        else if(f.equalsIgnoreCase("")||f.length()!=10)
        {
            ee6.setError("please give your Phone number");
            Toast.makeText(getApplicationContext(),"phone number missing", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i=getIntent();
            String k=i.getStringExtra("extra_8");
            Intent intent = new Intent(this, FORM.class);
            intent.putExtra("extra_1", a);
            intent.putExtra("extra_2", b);
            intent.putExtra("extra_3", c);
            intent.putExtra("extra_4", d);
            intent.putExtra("extra_5", e);
            intent.putExtra("extra_6", f);
            intent.putExtra("extra_i",g);
            intent.putExtra("extra_10", k);
            startActivity(intent);

           }
    }

}
