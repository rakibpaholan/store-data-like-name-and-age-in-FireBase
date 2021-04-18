package com.example.firebaserealtimedatabase_storedata;

public class Student {
    String user_name ;
    String age;

    public Student(String user_name, String age) {
        this.user_name = user_name;
        this.age = age;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
