package com.example.pegasus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Context mCtx;
    int listLayoutRes;
    ArrayList<Employee> employeList;
    List<Employee> employeeList=null;
    SQLiteDatabase mDatabase;

    public EmployeeAdapter(Context mCtx, int listLayoutRes, List<Employee> employeeList, SQLiteDatabase mDatabase) {
        super(mCtx, listLayoutRes, employeeList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.employeeList = employeeList;
        this.mDatabase = mDatabase;
        this.employeList=new ArrayList<Employee>();
        this.employeList.addAll(employeeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final Employee employee = employeeList.get(position);


        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);
        ImageView ima=view.findViewById(R.id.imageView5);
        textViewName.setText(employee.getName());
        textViewSalary.setText(String.valueOf(employee.getRollno()));
        ima.setImageURI(Uri.parse(employee.getImage()));
        Button buttonDelete = view.findViewById(R.id.buttonDeleteEmployee);
        Button buttonEdit = view.findViewById(R.id.buttonEditEmployee);
        Button buttonmore=view.findViewById(R.id.button11);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEmployee(employee);
            }
        });
        buttonmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                LayoutInflater inflater = LayoutInflater.from(mCtx);
                view= inflater.inflate(R.layout.activity_more, null);
                builder.setView(view);
                final TextView editTextName = view.findViewById(R.id.tttt1);
                final TextView editTextRollno = view.findViewById(R.id.tttt2);
                final TextView editTextAge = view.findViewById(R.id.tttt4);
                final TextView editTextEmail = view.findViewById(R.id.tttt5);
                final TextView editTextdob = view.findViewById(R.id.tttt6);
                final TextView editTextPhoneno = view.findViewById(R.id.tttt7);
                final ImageView imageView=view.findViewById(R.id.imageView44);
                editTextName.setText(employee.getName());
                editTextRollno.setText(String.valueOf(employee.getRollno()));
                editTextAge.setText(String.valueOf(employee.getAge()));
                editTextEmail.setText(employee.getEmail());
                editTextdob.setText(employee.getDob());
                editTextPhoneno.setText(String.valueOf(employee.getPhoneno()));
                String m=employee.getImage();
                Uri im=Uri.parse(m);
                imageView.setImageURI(im);
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM pool WHERE usern = ?";
                        mDatabase.execSQL(sql, new String[]{employee.getUsername()});
                        reloadEmployeesFromDatabase();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return view;
    }
    private void updateEmployee(final Employee employee) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.updateadmin, null);
        builder.setView(view);
        final EditText editTextName = view.findViewById(R.id.ekk1);
        final EditText editTextRollno = view.findViewById(R.id.ekk2);
        final EditText editTextAge = view.findViewById(R.id.ekk3);
        final EditText editTextEmail = view.findViewById(R.id.ekk4);
        final EditText editTextDob = view.findViewById(R.id.ekk5);
        final EditText editTextPhoneno = view.findViewById(R.id.ekk6);
        final ImageView imageView22=view.findViewById(R.id.imageView22);
        editTextName.setText(employee.getName());
        editTextRollno.setText(String.valueOf(employee.getRollno()));
        editTextAge.setText(String.valueOf(employee.getAge()));
        editTextEmail.setText(employee.getEmail());
        editTextDob.setText(employee.getDob());
        editTextPhoneno.setText(String.valueOf(employee.getPhoneno()));
        String m=employee.getImage();
        Uri im=Uri.parse(m);
        imageView22.setImageURI(im);
        final AlertDialog dialog = builder.create();
        dialog.show();
        view.findViewById(R.id.buttn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String rollno = editTextRollno.getText().toString().trim();
                String age = editTextAge.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String dob = editTextDob.getText().toString().trim();
                String phone = editTextPhoneno.getText().toString().trim();
                if (name.isEmpty()) {
                    editTextName.setError("Name can't be blank");
                    editTextName.requestFocus();
                    return;
                }

                if (rollno.isEmpty()) {
                    editTextRollno.setError("Roll number can't be blank");
                    editTextRollno.requestFocus();
                    return;
                }
                if (age.isEmpty()) {
                    editTextAge.setError("Age can't be blank");
                    editTextAge.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    editTextEmail.setError("Email can't be blank");
                    editTextEmail.requestFocus();
                    return;
                }
                if (dob.isEmpty()) {
                    editTextDob.setError("Date of birth can't be blank");
                    editTextDob.requestFocus();
                    return;
                }
                if (phone.isEmpty()) {
                    editTextPhoneno.setError("Phone number can't be blank");
                    editTextPhoneno.requestFocus();
                    return;
                }


                String sql = "UPDATE pool \n" +
                        "SET name = ?, \n"+
                        "rollno = ? \n," +
                        "age = ? \n," +
                        "email = ? \n," +
                        "dob = ? \n," +
                        "phoneno = ? \n" +
                        "WHERE usern = ?;\n";

                mDatabase.execSQL(sql, new String[]{name,rollno,age,email,dob,phone,employee.getUsername()});
                Toast.makeText(mCtx, "Detail Updated", Toast.LENGTH_SHORT).show();
                reloadEmployeesFromDatabase();
                dialog.dismiss();
            }
        });
    }

    private void reloadEmployeesFromDatabase() {
        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM pool", null);
        if (cursorEmployees.moveToFirst()) {
            employeeList.clear();
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
        notifyDataSetChanged();
    }

    public void filter(String text) {
        text =text.toLowerCase(Locale.getDefault());
        employeeList.clear();
        if(text.length()==0){employeeList.addAll(employeList);}
        else {
            for(Employee ep:employeList){
                if(ep.getName().toLowerCase(Locale.getDefault()).contains(text)){
                    employeeList.add(ep);
                }
            }
        }
        notifyDataSetChanged();
    }
}
