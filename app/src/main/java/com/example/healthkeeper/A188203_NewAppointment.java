package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.healthkeeper.ApptCustomSpinner.CustomSpinner;
import com.example.healthkeeper.ApptCustomSpinner.HospitalData_A188203;
import com.example.healthkeeper.ApptCustomSpinner.HospAdapterAppt_A188203;
import com.example.healthkeeper.ApptCustomSpinner.SpecAdapterAppt_A188203;
import com.example.healthkeeper.ApptCustomSpinner.SpecialistData_A188203;

public class A188203_NewAppointment extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener, View.OnClickListener {

    private CustomSpinner SpinnerHosp, SpinnerSpec;
    private HospAdapterAppt_A188203 hospAdapter;
    private SpecAdapterAppt_A188203 specAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment_a188203);

        SpinnerHosp = findViewById(R.id.spinner_hospital);
        SpinnerHosp.setSpinnerEventsListener(this);

        SpinnerSpec = findViewById(R.id.spinner_specialist);
        SpinnerSpec.setSpinnerEventsListener(this);

        hospAdapter = new HospAdapterAppt_A188203(A188203_NewAppointment.this, HospitalData_A188203.getHospitalList());
        SpinnerHosp.setAdapter(hospAdapter);

        specAdapter = new SpecAdapterAppt_A188203(A188203_NewAppointment.this, SpecialistData_A188203.getSpecList());
        SpinnerSpec.setAdapter(specAdapter);

        Button bookNow = (Button) findViewById(R.id.btn_booknow);
        bookNow.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        SpinnerHosp.setBackground(getResources().getDrawable(R.drawable.bg_spinner_appt_up));
        SpinnerSpec.setBackground(getResources().getDrawable(R.drawable.bg_spinner_appt_up));

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        SpinnerHosp.setBackground(getResources().getDrawable(R.drawable.bg_spinner_appt));
        SpinnerSpec.setBackground(getResources().getDrawable(R.drawable.bg_spinner_appt));

    }

    public void onClick(View v) {
        Intent i;
        int id = v.getId();
        if (id == R.id.btn_booknow) {
            i = new Intent(this, A188203_BookedAppointment.class);
            startActivity(i);
        }
    }
}

