package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class A188203_AppointmentActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgBtnEmail, imgBtnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_a188203);

        Button MakeAppt = (Button) findViewById(R.id.btn_makeappt);

        imgBtnEmail = findViewById(R.id.img_btn_email3);
        imgBtnCall = findViewById(R.id.img_btn_call);
        imgBtnEmail.setOnClickListener(this);
        imgBtnCall.setOnClickListener(this);

        MakeAppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A188203_AppointmentActivity.this, A188203_NewAppointment.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_btn_email3) {
            Toast.makeText(A188203_AppointmentActivity.this, "Email Me.", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Dermatology Appointment");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi Dr Suzanna. I would like to ask about my appointment.");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "suzanna@healthkeeper.com"});

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
            else {
                Toast.makeText(A188203_AppointmentActivity.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.img_btn_call) {
            Toast.makeText(A188203_AppointmentActivity.this, "Call Me.", Toast.LENGTH_SHORT).show();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel: 0133484189"));

            if(callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            }
            else  {
                Toast.makeText(A188203_AppointmentActivity.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}