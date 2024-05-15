package com.example.healthkeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;

import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class A187951_LoginActivity extends AppCompatActivity {

    ImageView imageView;
    Drawable drawable;
    protected TextView tvEmail, tvPassword, tvSignup;
    protected EditText etEmail, etPassword;
    protected Button btnLogin;
    private FirebaseAuth mFirebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_a187951);

        imageView = findViewById(R.id.img_login);
        drawable = getResources().getDrawable(R.drawable.healthkeeper);
        imageView.setImageDrawable(drawable);

        //link all the view
        tvSignup = (TextView) findViewById(R.id.login_tv_sign_up);
        etEmail = (EditText) findViewById(R.id.login_et_email);
        etPassword = (EditText) findViewById(R.id.login_et_password);
        btnLogin = (Button) findViewById(R.id.login_btn_login);

        //initialize FirebaseAuth
        mFirebaseAuth = FirebaseAuth.getInstance();

        //implement the signup function
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

                password = password.trim();
                email = email.trim();

                if (password.isEmpty() || email.isEmpty()) {
                    //remind user to key in the data
                    AlertDialog.Builder builder = new AlertDialog.Builder(A187951_LoginActivity.this);
                    builder.setMessage("Please enter an email and password").setTitle("Warning").setPositiveButton("OK" , null);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

                else {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(A187951_LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                GoToMainActivity();
                            }

                            else
                            {
                                Toast.makeText(A187951_LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

                password = password.trim();
                email = email.trim();

                if (password.isEmpty() || email.isEmpty()) {
                    //remind user to key in the data
                    AlertDialog.Builder builder = new AlertDialog.Builder(A187951_LoginActivity.this);
                    builder.setMessage("Please enter an email and password").setTitle("Warning").setPositiveButton("OK" , null);

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

                else {
                    mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(A187951_LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                GoToMainActivity();
                            }

                            else
                            {
                                Toast.makeText(A187951_LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });

    }

    private void GoToMainActivity()
    {
        Intent intent = new Intent(A187951_LoginActivity.this, A188203_MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}