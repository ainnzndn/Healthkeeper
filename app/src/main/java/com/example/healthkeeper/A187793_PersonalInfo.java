package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class A187793_PersonalInfo extends AppCompatActivity {

    EditText etName, etDOB, etGender, etAddress, etNumber, etEmail;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String SP_NAME = "name";
    String SP_DOB = "dob";
    String SP_GENDER = "gender";
    String SP_ADDRESS = "address";
    String SP_NUMBER = "number";
    String SP_EMAIL = "email";

    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a187793_personal_info);

        etName = findViewById(R.id.et_name);
        etDOB = findViewById(R.id.et_dob);
        etGender = findViewById(R.id.et_gender);
        etAddress = findViewById(R.id.et_address);
        etNumber = findViewById(R.id.et_number);
        etEmail = findViewById(R.id.et_email);
        btnSave = findViewById(R.id.btn_save);

        sharedPref = getSharedPreferences("app_setting", MODE_PRIVATE);
        editor = sharedPref.edit();

        etName.setText(sharedPref.getString(SP_NAME, ""));
        etDOB.setText(sharedPref.getString(SP_DOB, ""));
        etGender.setText(sharedPref.getString(SP_GENDER, ""));
        etAddress.setText(sharedPref.getString(SP_ADDRESS, ""));
        etNumber.setText(sharedPref.getString(SP_NUMBER, ""));
        etEmail.setText(sharedPref.getString(SP_EMAIL, ""));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String dob = etDOB.getText().toString();
                String gender = etGender.getText().toString();
                String address = etAddress.getText().toString();
                String number = etNumber.getText().toString();
                String email = etEmail.getText().toString();


                editor.putString(SP_NAME, name);
                editor.putString(SP_DOB, dob);
                editor.putString(SP_GENDER, gender);
                editor.putString(SP_ADDRESS, address);
                editor.putString(SP_NUMBER, number);
                editor.putString(SP_EMAIL, email);
                editor.commit();

                Toast.makeText(A187793_PersonalInfo.this, "Personal Information Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });



    }

}