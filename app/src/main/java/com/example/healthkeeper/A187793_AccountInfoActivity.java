package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class A187793_AccountInfoActivity extends AppCompatActivity {

    Button btnPersonalInfo, btnHealthInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info_a187793);

        btnPersonalInfo = (Button) findViewById(R.id.btn_personal_information);
        btnHealthInfo = (Button) findViewById(R.id.btn_health_information);

        btnPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A187793_AccountInfoActivity.this, A187793_PersonalInfo.class);
                startActivity(intent);
            }
        });

        btnHealthInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A187793_AccountInfoActivity.this, A187793_HealthInfo.class);
                startActivity(intent);
            }
        });
    }
}