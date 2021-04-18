package com.example.firebaserealtimedatabase_storedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText user_name,age;
    private Button store_data;
    private DatabaseReference databaseReference;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*reference need */
        databaseReference = FirebaseDatabase.getInstance().getReference();

        user_name = (EditText)findViewById(R.id.user_name_id);
        age = (EditText)findViewById(R.id.age_id);
        store_data = (Button)findViewById(R.id.store_data);
        store_data.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.store_data:
                inputData();
                break;
        }
    }

    private void inputData() {
        String user_name_value = user_name.getText().toString().trim();
        String user_age_value = age.getText().toString().trim();
        String key = databaseReference.push().getKey();
        student = new Student(user_name_value,user_age_value);
        databaseReference.child(key).setValue(student);
        user_name.setText("");
        age.setText("");
        Toast.makeText(getApplicationContext(),"Data Successfuly inserted",Toast.LENGTH_SHORT).show();

    }
}