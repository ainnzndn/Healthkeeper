package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class A187793_HealthInfo extends AppCompatActivity {

    EditText etWeight, etHeight, etBmi, etBlood, etCholestrol, etFood, etSurgeries;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String SP_WEIGHT = "weight";
    String SP_HEIGHT = "height";
    String SP_BMI = "bmi";
    String SP_BLOOD = "blood";
    String SP_CHOLESTROL = "cholestrol";
    String SP_FOOD = "food";
    String SP_SURGERIES = "surgeries";

    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a187793_health_info);

        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        etBmi = findViewById(R.id.et_bmi);
        etBlood = findViewById(R.id.et_bloodsugar);
        etCholestrol = findViewById(R.id.et_cholestrol);
        etFood = findViewById(R.id.et_foodallergies);
        etSurgeries = findViewById(R.id.et_surgeries);
        btnSave = findViewById(R.id.btn_save_health);

        etWeight.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etHeight.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etBmi.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etBlood.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etCholestrol.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        sharedPref = getSharedPreferences("app_setting", MODE_PRIVATE);
        editor = sharedPref.edit();

        etWeight.setText(sharedPref.getString(SP_WEIGHT, ""));
        etHeight.setText(sharedPref.getString(SP_HEIGHT, ""));
        etBmi.setText(sharedPref.getString(SP_BMI, ""));
        etBlood.setText(sharedPref.getString(SP_BLOOD, ""));
        etCholestrol.setText(sharedPref.getString(SP_CHOLESTROL, ""));
        etFood.setText(sharedPref.getString(SP_FOOD, ""));
        etSurgeries.setText(sharedPref.getString(SP_SURGERIES, ""));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = etWeight.getText().toString();
                String height = etHeight.getText().toString();
                String bmi = etBmi.getText().toString();
                String blood = etBlood.getText().toString();
                String cholestrol = etCholestrol.getText().toString();
                String food = etFood.getText().toString();
                String surgeries = etSurgeries.getText().toString();

                editor.putString(SP_WEIGHT, weight);
                editor.putString(SP_HEIGHT, height);
                editor.putString(SP_BMI, bmi);
                editor.putString(SP_BLOOD, blood);
                editor.putString(SP_CHOLESTROL, cholestrol);
                editor.putString(SP_FOOD, food);
                editor.putString(SP_SURGERIES, surgeries);
                editor.commit();

                Toast.makeText(A187793_HealthInfo.this, "Health Information Saved Successfully", Toast.LENGTH_SHORT).show();




            }
        });
    }
}