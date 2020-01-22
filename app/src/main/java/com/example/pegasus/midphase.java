package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class midphase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midphase);
    }
    public void on(View view){
        Intent intent = new Intent(this, pre_registered.class);
        Intent inten = getIntent();
        String u = inten.getStringExtra("extra_15");
        intent.putExtra("extra_12",u);
        startActivity(intent);
    }
    public void on1(View view){
        Intent intent = new Intent(this, adm.class);
        Intent inten = getIntent();
        String u = inten.getStringExtra("extra_15");
        intent.putExtra("extra_12",u);
        startActivity(intent);
    }
}
