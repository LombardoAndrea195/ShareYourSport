package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button blogin;
    private  ProgressBar simpleProgressBar;

    private TextView SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        blogin = (Button) findViewById(R.id.login);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        SignUp = (TextView) findViewById(R.id.Signup);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleProgressBar.setVisibility(View.VISIBLE);
                startSignIn();

                simpleProgressBar.setVisibility(View.INVISIBLE);
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleProgressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(LoginActivity.this, FormRegisterActivity.class));

                simpleProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }






    private void startSignIn() {
        String email_check = email.getText().toString();
        String password_check = password.getText().toString();

        if (email_check.isEmpty() ) {
            email.setError("Please enter your email:");
            email.requestFocus();

            Toast.makeText(LoginActivity.this, "Field is empty", Toast.LENGTH_LONG).show();
        }
            else if (password_check.isEmpty()){

            password.setError("Please enter your password:");
            password.requestFocus();

            Toast.makeText(LoginActivity.this, "Field password is empty", Toast.LENGTH_LONG).show();

        }else
         {
            //bisogna implementare in login SIGN IN


        }
    }

}
