package com.example.pegasus;

import java.sql.Blob;

public class Employee {
    String name,dob,email,username,image;
    int rollno,age,phoneno;
    public Employee(String username, String name, int rollno, int age, String email, String dob, int phoneno, String image) {
        this.username=username;
        this.name = name;
        this.rollno = rollno;
        this.age=age;
        this.email=email;
        this.dob=dob;
        this.phoneno=phoneno;
        this.image=image;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public int getRollno() {
        return rollno;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getDob() {
        return dob;
    }
    public int getPhoneno() {
        return phoneno;
    }
    public String getImage(){return image;}

}
