package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        Bback=(Button) findViewById(R.id.back);
        Name1 = (TextView) findViewById(R.id.firstname);
        Surname1 = (TextView) findViewById(R.id.secondname);
        Female = (Switch) findViewById(R.id.F);
        Male = (Switch) findViewById(R.id.M);
        picture = (CircleImageView) findViewById(R.id.profile_image);
        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");


            byte[] byteArray = extras.getByteArray("picture");
            byteArray2=byteArray;
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


            picture.setImageBitmap(bmp);

            System.out.println(email);
            System.out.println(Name);
            System.out.println(Surname);

            Name1.setText(Name);
            Surname1.setText(Surname);
        Bback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              Intent  intent = new Intent(SecondActivity.this , FormRegisterActivity.class);

//Bundle is optional
//end Bundle
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




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
                intent.putExtra("Email", extras.getString("Email"));
                intent.putExtra("City", City.getText().toString());
                intent.putExtra("Date", Date.getText().toString());
                intent.putExtra("picture",byteArray2);
                intent.putExtra("password", extras.getString("password"));
                intent.putExtra( "Sex",Sex);
                startActivity(intent);

            }
        });

    }}


    }
