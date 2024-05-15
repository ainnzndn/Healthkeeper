package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class A188203_BookedAppointment extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBtnEmail1, imgBtnEmail2, imgBtnEmail3;
    private ImageView imgBtnCall1, imgBtnCall2, imgBtnCall3;
    private Button btnCancel1, btnCancel2, btnCancel3;
    private Button btnComplete1, btnComplete2, btnComplete3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_appointment_a188203);
        ImageView MainMenu = (ImageView) findViewById(R.id.btn_mainmenu);

        imgBtnEmail1 = findViewById(R.id.imgbtn_email1);
        imgBtnEmail2 = findViewById(R.id.imgbtn_email2);
        imgBtnEmail3 = findViewById(R.id.imgbtn_email3);
        imgBtnCall1 = findViewById(R.id.imgbtn_call1);
        imgBtnCall2 = findViewById(R.id.imgbtn_call2);
        imgBtnCall3 = findViewById(R.id.imgbtn_call3);
        btnCancel1 = findViewById(R.id.btn_cancel1);
        btnCancel2 = findViewById(R.id.btn_cancel2);
        btnCancel3 = findViewById(R.id.btn_cancel3);
        btnComplete1 = findViewById(R.id.btn_complete1);
        btnComplete2 = findViewById(R.id.btn_complete2);
        btnComplete3 = findViewById(R.id.btn_complete3);
        imgBtnEmail1.setOnClickListener(this);
        imgBtnEmail2.setOnClickListener(this);
        imgBtnEmail3.setOnClickListener(this);
        imgBtnCall1.setOnClickListener(this);
        imgBtnCall2.setOnClickListener(this);
        imgBtnCall3.setOnClickListener(this);

        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A188203_BookedAppointment.this, A188203_MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgbtn_email1) {
            Toast.makeText(A188203_BookedAppointment.this, "Email Me.", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Dentistry Appointment");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello, Dr Ammar Zairi. I would like to ask about my appointment.");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "ammarzairi@healthkeeper.com"});

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
            else {
                Toast.makeText(A188203_BookedAppointment.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.imgbtn_call1) {
            Toast.makeText(A188203_BookedAppointment.this, "Call Dr. Ammar", Toast.LENGTH_SHORT).show();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel: 0198873080"));

            if(callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            }
            else  {
                Toast.makeText(A188203_BookedAppointment.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.imgbtn_email2) {
            Toast.makeText(A188203_BookedAppointment.this, "Email Me.", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Veterinary Appointment");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi, Dr Ying. I would like to ask about my appointment.");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "yinglan@healthkeeper.com"});

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
            else {
                Toast.makeText(A188203_BookedAppointment.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.imgbtn_call2) {
            Toast.makeText(A188203_BookedAppointment.this, "Call Dr. Ying", Toast.LENGTH_SHORT).show();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel: 0129565009"));

            if(callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            }
            else  {
                Toast.makeText(A188203_BookedAppointment.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.imgbtn_email3) {
            Toast.makeText(A188203_BookedAppointment.this, "Email Dr. Michael", Toast.LENGTH_SHORT).show();
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Surgery Appointment");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Greetings, Dr Michael. I would like to ask about my appointment.");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "michaelang@healthkeeper.com"});

            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
            else {
                Toast.makeText(A188203_BookedAppointment.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.imgbtn_call3) {
            Toast.makeText(A188203_BookedAppointment.this, "Call Dr. Michael", Toast.LENGTH_SHORT).show();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel: 0176552727"));

            if (callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            } else {
                Toast.makeText(A188203_BookedAppointment.this, "Sorry, please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
