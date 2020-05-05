package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {

    private Button next;
    private CircleImageView picture;
    private EditText City;
    private Button Bback;
    private EditText Date;
    private TextView Name1;
    private TextView Surname1;
    private Switch Male;

    private byte[] byteArray2;
    private Switch Female;
    private boolean M=false,F=false;
    private String Sex;
    private  String password,email;
    private String Name,Surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        Bback = (Button) findViewById(R.id.back);
        Name1 = (TextView)findViewById(R.id.name);
        Surname1 = (TextView) findViewById(R.id.surname);
        Female = (Switch) findViewById(R.id.F);
        Male = (Switch) findViewById(R.id.M);
        next=(Button) findViewById(R.id.next);
        picture = (CircleImageView) findViewById(R.id.profile_image);
        City=(EditText)findViewById(R.id.city);
        Date=(EditText) findViewById(R.id.date);

        if (extras != null) {
             email = extras.getString("Email");
            Name = extras.getString("Name");
             Surname = extras.getString("Surname");
             password = extras.getString("password");


            int imageURi = extras.getInt("picture");
            picture.setImageResource(imageURi);

            System.out.println(email);
            System.out.println(Name);
            System.out.println(Surname);

            Name1.setText(Name);
            Surname1.setText(Surname);
        }
            Bback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
             back();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            next();



    }});

    }
    private void next(){

        Male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    M = true;
                } else {
                    M = false;
                }
            }
        });
        Female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    F = true;
                } else {
                    F = false;
                }
            }
        });
        if (F == true && M == true) {
            Female.setError("Set only one Sex option");
            Male.setError("Set only one Sex option");
            Female.requestFocus();
            Male.requestFocus();

            Toast.makeText(SecondActivity.this, "Select only one", Toast.LENGTH_LONG).show();
        } else if (F == false && M == false) {
            Female.setError("Set one Sex option");
            Male.setError("Set one Sex option");
            Female.requestFocus();
            Male.requestFocus();

            Toast.makeText(SecondActivity.this, "Select one", Toast.LENGTH_LONG).show();

        } else if (F == true && M == false) {
            Sex = "Female";
        } else {
            Sex = "Male";
        }
        if (Date.getText().toString().isEmpty()) {
            Date.setError("Please enter your birthday's date:");
            Date.requestFocus();

            Toast.makeText(SecondActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

        }

        Date birthday = validateDateFormat(Date.toString());

        if (City.getText().toString().isEmpty()) {
            City.setError("Please enter your city:");
            City.requestFocus();

            Toast.makeText(SecondActivity.this, "Field is empty", Toast.LENGTH_LONG).show();
        }


        Intent intent = new Intent(SecondActivity.this, FinishRegistrationActivity.class);
        intent.putExtra("Name", Name1.getText().toString());
        intent.putExtra("Surname", Surname1.getText().toString());
        intent.putExtra("Email", email);
        intent.putExtra("City", City.getText().toString());
        intent.putExtra("Date", Date.getText().toString());
        intent.putExtra("picture",R.id.profile_image);
        intent.putExtra("password", password);
        intent.putExtra( "Sex",Sex);
        startActivity(intent);


    }
    private void back(){
        Intent  intent = new Intent(SecondActivity.this , FormRegisterActivity.class);
        startActivity(intent);
        finish();
    }
    public Date validateDateFormat(String dateToValdate) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //To make strict date format validation
        formatter.setLenient(false);
        java.util.Date parsedDate = null;
        try {
            parsedDate = formatter.parse(dateToValdate);
            System.out.println("++validated DATE TIME ++"+formatter.format(parsedDate));

        } catch (ParseException e) {
            Date.setError("Inserirela data come indiata dd-MM-yyyy");
            Date.requestFocus();
        }
        return parsedDate;
    }
}



