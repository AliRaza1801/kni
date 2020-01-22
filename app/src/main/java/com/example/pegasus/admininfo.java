package com.example.pegasus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class admininfo extends AppCompatActivity implements SearchView.OnQueryTextListener {
    List<Employee> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    EmployeeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admininfo);
        listViewEmployees = (ListView)findViewById(R.id.listViewEmployees);
        employeeList = new ArrayList<>();
        mDatabase =openOrCreateDatabase(MainActivity.DATABASE_NAME,MODE_PRIVATE,null);
        Button b1=(Button) findViewById(R.id.sorta_z);
        Button b2=(Button) findViewById(R.id.sortz_a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admininfo.this,admininfo2.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admininfo.this,admininfo3.class));
            }
        });
        showEmployeesFromDatabase();
    }
    private void showEmployeesFromDatabase() {
        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM pool", null);
        if (cursorEmployees.moveToFirst()) {
            do {
                employeeList.add(new Employee(
                        cursorEmployees.getString(0),
                        cursorEmployees.getString(1),
                        cursorEmployees.getInt(2),
                        cursorEmployees.getInt(3),
                        cursorEmployees.getString(4),
                        cursorEmployees.getString(5),
                        cursorEmployees.getInt(6),
                        cursorEmployees.getString(7)

                ));
            } while (cursorEmployees.moveToNext());
        }
        cursorEmployees.close();
        adapter = new EmployeeAdapter(this, R.layout.list_layout_employee, employeeList, mDatabase);
        listViewEmployees.setAdapter(adapter);
        SearchView searchView=findViewById(R.id.search);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String text=s;
        adapter.filter(text);
        return false;
    }
}
