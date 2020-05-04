package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {

    private Button next;
    private CircleImageView picture;
    private Uri imageUri;
    private EditText City;
    private static final int PICK_IMAGE = 100;
    private EditText Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        picture = (CircleImageView) findViewById(R.id.profile_image);

        next.setOnClickListener(onNewIntent());
        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");
            String value5 = extras.getString("picture");
            Uri imageUri = Uri.parse(value5);
            picture.setImageURI(imageUri);


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
