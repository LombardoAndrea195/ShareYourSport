package com.example.andrea.shareyoursport;

import android.app.TimePickerDialog;
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
import androidx.fragment.app.DialogFragment;

import de.hdodenhof.circleimageview.CircleImageView;


public class NewEventActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener {
    private Button next;
    private TextView Name1,hour;
    private TextView Surname1;
    private EditText place,Date;
    private TextView annotations,nUTente;
    private RadioButton A,B,C;
    private String Level;

    private CircleImageView picture;
    private Spinner sport;

    public int minuts,hours,nMaxUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        place=(EditText)findViewById(R.id.place);
        annotations=(TextView)findViewById(R.id.annotations);
        Date=(EditText) findViewById(R.id.date);
        Bundle extras = getIntent().getExtras();
        Name1 = (TextView) findViewById(R.id.name);
        Surname1 = (TextView) findViewById(R.id.surname);
        picture = (CircleImageView) findViewById(R.id.profile_image);
        sport=(Spinner)findViewById(R.id.Sport);
        nUTente=(TextView) findViewById(R.id.nUtenti);

        A=(RadioButton)findViewById(R.id.A);
        B=(RadioButton)findViewById(R.id.B);
        C=(RadioButton)findViewById(R.id.C);
        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");

            Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");
            picture.setImageBitmap(bitmap);
            Name1.setText(Name);

            Surname1.setText(Surname);

            ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Sport,android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sport.setAdapter(adapter);
         //   sport.setOnItemClickListener((AdapterView.OnItemClickListener) this);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    checkDate();
                    check_place();
                    check_Annotations();
                    checkNUtente();
                    onRadioButtonClicked(v);





                    Intent intent = new Intent(NewEventActivity.this, MenuActivity.class);
                    intent.putExtra("Name", extras.getString("Name"));
                    intent.putExtra("Surname", extras.getString("Surname"));
                    intent.putExtra("Email", extras.getString("Email"));
                    startActivity(intent);

                }
            });
            hour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                DialogFragment timePicker = new TimePicker();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }

        });

    }
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

                    A.setClickable(false);
                    B.setClickable(false);
                }
                break;
        }

    }
    private void checkNUtente(){
        if (nUTente.getText().toString().isEmpty()) {
            nUTente.setError("Please enter max number of users:");
            nUTente.requestFocus();

            Toast.makeText(NewEventActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

        }
        else if(Integer.parseInt(nUTente.getText().toString())<=0){
            nUTente.setError("Please enter a valid number:");
            nUTente.requestFocus();

            Toast.makeText(NewEventActivity.this, "Field non valid", Toast.LENGTH_LONG).show();

        }
        nMaxUsers=Integer.parseInt(nUTente.getText().toString());
    }
    private void check_Annotations(){
        if (annotations.getText().toString().isEmpty()) {
            annotations.setError("Please enter some information about your sport date:");
            annotations.requestFocus();

            Toast.makeText(NewEventActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

        }
    }
    private void check_place(){
        if (place.getText().toString().isEmpty()) {
            place.setError("Please enter your meeting point:");
            place.requestFocus();

            Toast.makeText(NewEventActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

        }
    }
    private void checkDate(){
        if (Date.getText().toString().isEmpty()) {
            Date.setError("Please enter your event's date:");
            Date.requestFocus();

            Toast.makeText(NewEventActivity.this, "Field is empty", Toast.LENGTH_LONG).show();

        }
        else if(Date.getText().toString().length()!=8){
            Date.setError("Please enter your event's date:");
            Date.requestFocus();

            Toast.makeText(NewEventActivity.this, "Field should be as 06032020", Toast.LENGTH_LONG).show();

        }

}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),selected,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(parent.getContext(),"Error select one",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {

            TextView textView = (TextView) findViewById(R.id.hour);
            hours=hourOfDay;
            minuts=minute;
            textView.setText("Hour: " + hourOfDay + " Minute: " + minute);
    }
}