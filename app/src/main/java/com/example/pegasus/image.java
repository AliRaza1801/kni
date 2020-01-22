package com.example.pegasus;

import android.app.DatePickerDialog;
import android.content.Intent;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class image extends AppCompatActivity {
    final static int pickimg=100;
    Button button;
    ImageView imagee=(ImageView)findViewById(R.id.imageView22);;
    Uri imageUri;
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
            imagee.setImageURI(imageUri);
        }
    }
}
