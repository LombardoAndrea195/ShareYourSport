package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button blogin;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email=(EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        blogin=(Button) findViewById(R.id.login);
        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(LoginActivity.this,MenuActivity.class));
                }
            }
        };
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    private void startSignIn(){
        String email_check=email.getText().toString();
        String password_check=password.getText().toString();

        if(TextUtils.isEmpty(email_check)|| TextUtils.isEmpty(password_check)){
            Toast.makeText(LoginActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();

        }
        else {
            mAuth.signInWithEmailAndPassword(email_check, password_check).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Sign In Problem", Toast.LENGTH_LONG).show();
                        //updateUI(null);
                    }
                    else {
                        FirebaseUser user = mAuth.getCurrentUser();
                        //updateUI(user);
                    }
                }
            });
        }
    }
}
