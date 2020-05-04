package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button blogin;
    private  ProgressBar simpleProgressBar;

    private FirebaseAuth mAuth;
    private TextView SignUp;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        blogin = (Button) findViewById(R.id.login);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
        SignUp = (TextView) findViewById(R.id.Signup);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    simpleProgressBar.setVisibility(View.VISIBLE);
                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));

                    simpleProgressBar.setVisibility(View.INVISIBLE);
                }
            }
        };
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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }


    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;
 /*   private ActivityGoogleBinding mBinding;


    protected void Google_SignIn (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGoogleBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setProgressBar(mBinding.progressBar);

        // Button listeners
        mBinding.signInButton.setOnClickListener(this);

        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUI(null);
                // [END_EXCLUDE]
            }
        }
    }
    // [END onactivityresult]
*/
    // [START auth_with_google]
  /*  private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
        showProgressBar();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*/
    private void startSignUp() {


        String email_check = email.getText().toString();
        String password_check = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(email_check, password_check)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(LoginActivity.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
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
            mAuth.signInWithEmailAndPassword(email_check, password_check).addOnCompleteListener(LoginActivity.this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Login error", Toast.LENGTH_LONG).show();
                            } else {

                        Intent intToHome=new Intent(LoginActivity.this,MenuActivity.class);
                        startActivity(intToHome);

                        FirebaseUser userInstance = FirebaseAuth.getInstance().getCurrentUser();
                        if (userInstance != null) {
                            // Name, email address, and profile photo Url
                            String name = userInstance.getDisplayName();
                            String email = userInstance.getEmail();
                            Uri photoUrl = userInstance.getPhotoUrl();

                            // Check if user's email is verified
                            boolean emailVerified = userInstance.isEmailVerified();

                            // The user's ID, unique to the Firebase project. Do NOT use this value to
                            // authenticate with your backend server, if you have one. Use
                            // FirebaseUser.getIdToken() instead.
                            String uid = userInstance.getUid();
                        }
                    }
                }
            });
        }
    }

}
