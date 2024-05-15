package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class A188203_MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView MedicalRecords, AccountInfo, Appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MedicalRecords = (CardView) findViewById(R.id.cv_medicalrecords);
        AccountInfo = (CardView) findViewById(R.id.cv_accountinfo);
        Appointment = (CardView) findViewById(R.id.cv_appointment);

        MedicalRecords.setOnClickListener((View.OnClickListener) this);
        AccountInfo.setOnClickListener((View.OnClickListener) this);
        Appointment.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void  onClick(View v) {
        Intent i;
        int id = v.getId();
        if (id == R.id.cv_medicalrecords) {
            i = new Intent(this, A187951_MedicalRecordsActivity.class);
            startActivity(i);
        } else if (id == R.id.cv_accountinfo) {
            i = new Intent(this, A187793_AccountInfoActivity.class);
            startActivity(i);
        } else if (id == R.id.cv_appointment) {
            i = new Intent(this, A188203_AppointmentActivity.class);
            startActivity(i);
        }
    }

}