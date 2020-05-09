package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchEventActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button next;
    private TextView Name1;
    private TextView Surname1;
    private EditText City,Date;
    private Spinner Sport;

    private RadioButton A,B,C;
    private String Level;
    public String SportText;
    private CircleImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        Bundle extras = getIntent().getExtras();
        Name1 = (TextView) findViewById(R.id.name);
        A=(RadioButton)findViewById(R.id.A);
        B=(RadioButton)findViewById(R.id.B);
        C=(RadioButton)findViewById(R.id.C);
        Surname1 = (TextView) findViewById(R.id.surname);
        picture = (CircleImageView) findViewById(R.id.profile_image);
        Sport= (Spinner) findViewById(R.id.Sport);
        next=(Button) findViewById(R.id.next);
        picture = (CircleImageView) findViewById(R.id.profile_image);
        City=(EditText)findViewById(R.id.place);
        Date=(EditText) findViewById(R.id.date);
        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");
            String Date = extras.getString("Date");
            String Sex = extras.getString("Sex");
            String City = extras.getString("City");

            Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");
            picture.setImageBitmap(bitmap);
            Name1.setText(Name);
            Surname1.setText(Surname);
        }

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    checkSport();
                    checkDate();

                    System.out.println(Date);
                 //   java.util.Date birthday = validateDateFormat(Date.toString());

                    if (City.getText().toString().isEmpty()) {
                        City.setError("Please enter your city:");
                        City.requestFocus();

                        Toast.makeText(SearchEventActivity.this, "Field is empty", Toast.LENGTH_LONG).show();
                    }


else {
                        onRadioButtonClicked(v);

                        Intent intent = new Intent(SearchEventActivity.this, ResultEventActivity.class);
                        intent.putExtra("Name", extras.getString("Name"));
                        intent.putExtra("Surname", extras.getString("Surname"));
                        intent.putExtra("Email", extras.getString("Email"));
                        intent.putExtra("City", extras.getString("City"));
                        intent.putExtra("Date", extras.getString("Date"));
                        picture.buildDrawingCache();
                        Bitmap bitmap = picture.getDrawingCache();
                        intent.putExtra("Bitmap", bitmap);

                        intent.putExtra("password", extras.getString("password"));
                        startActivity(intent);

                    }}
            });

        }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.A:
                if (checked) {
                    Level = "Easy";
                    B.setChecked(false);
                    C.setChecked(false);

                    B.setClickable(false);
                    C.setClickable(false);
                }
                break;
            case R.id.B:
                if (checked) {
                    Level = "Middle";
                    A.setChecked(false);
                    C.setChecked(false);

                    A.setClickable(false);
                    C.setClickable(false);
                }
                break;
            case R.id.C:
                if (checked){
                    Level="Hard";
                    A.setChecked(false);
                    B.setChecked(false);

                    B.setClickable(false);
                    A.setClickable(false);
                }
                break;
        }

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
    private void checkSport(){

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Sport,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Sport.setAdapter(adapter);
   //     Sport.setOnItemClickListener((AdapterView.OnItemClickListener) this);


    }
    private void checkDate(){
        if (Date.getText().toString().isEmpty()) {
            Date.setError("Please enter your birthday's date:");
            Date.requestFocus();

            Toast.makeText(SearchEventActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

        }
        else if(Date.getText().toString().length()!=8){
            Date.setError("Please enter your birthday's date:");
            Date.requestFocus();

            Toast.makeText(SearchEventActivity.this, "Field should be as 06071995", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        SportText=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"selected "+SportText,Toast.LENGTH_LONG ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    }

