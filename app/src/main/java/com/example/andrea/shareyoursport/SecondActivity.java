package com.example.andrea.shareyoursport;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {

    private Button next;
    private CircleImageView picture;
    private Uri imageUri;
    private EditText City;
    private static final int PICK_IMAGE = 100;
    private EditText Date;
    private TextView Name1;
    private TextView Surname1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        Name1=(TextView) findViewById(R.id.firstname);
        Surname1=(TextView) findViewById(R.id.secondname);

        picture = (CircleImageView) findViewById(R.id.profile_image);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extras != null) {
                    String email = extras.getString("Email");
                    String Name = extras.getString("Name");
                    String Surname = extras.getString("Surname");
                    String password = extras.getString("password");
                    String value5 = extras.getString("picture");
                    Uri imageUri = Uri.parse(value5);
                    picture.setImageURI(imageUri);
                    Name1.setText(Name);
                    Surname1.setText(Surname);


                }
                if(Date.getText().toString().isEmpty()){
                    Date.setError("Please enter your birthday's date:");
                    Date.requestFocus();

                    Toast.makeText(SecondActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

                }
                if (City.getText().toString().isEmpty() ) {
                    City.setError("Please enter your city:");
                    City.requestFocus();

                    Toast.makeText(SecondActivity.this, "Field is empty", Toast.LENGTH_LONG).show();
                }
                else if (.isEmpty()){

                    password.setError("Please enter your password:");
                    password.requestFocus();

                    Toast.makeText(LoginActivity.this, "Field password is empty", Toast.LENGTH_LONG).show();



                });


        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            picture.setImageURI(imageUri);

        }
}
