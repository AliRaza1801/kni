package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void buu8(View view){
        Intent intent=new Intent(admin.this,MainActivity.class);
        startActivity(intent);
    }
    public void bdd4(View view){
        EditText en=findViewById(R.id.Ausername);
        EditText en1=findViewById(R.id.Apassword);
        String a=en.getText().toString();
        String b=en1.getText().toString();
        if(a.equalsIgnoreCase(""))
        {
            en.setError("please enter any username");
        }
        else if(b.equalsIgnoreCase(""))
        {
            en1.setError("please enter any password");
        }
        else if ((!b.equals("admin")) && a.equals("admin")) {
            en1.setError("Wrong Password");
        }
        else if ((!a.equals("admin"))) {
            en.setError("Wrong USERNAME");
        }
        else if(a.equals("admin")&&b.equals("admin"))
        {
            Intent intent = new Intent(this, splash1.class);
            Toast.makeText(getApplicationContext(), "WELCOME BACK ADMIN", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }
    }
}
