package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuestionarieActivity extends AppCompatActivity {
    private Button next;
    private EditText height,weight;
    private TextView Name1;
    private TextView Surname1;
    private List<String> preferences;
    private CircleImageView picture;
    private CheckBox Tennis,Football,Gym,Yoga,Swimming,Running;
    private RadioButton A,B,C;
    private String Level;
    private String Height,Weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionarie);
        Tennis = (CheckBox)findViewById(R.id.Tennis);
        Football = (CheckBox)findViewById(R.id.Football);
        Yoga = (CheckBox)findViewById(R.id.Yoga);
        Gym = (CheckBox)findViewById(R.id.Gym);
        A=(RadioButton)findViewById(R.id.A);
        B=(RadioButton)findViewById(R.id.B);
        C=(RadioButton)findViewById(R.id.C);
        Swimming=(CheckBox)findViewById(R.id.Swimming);
        Running=(CheckBox)findViewById(R.id.Running);
        next=(Button) findViewById(R.id.next);
        Bundle extras = getIntent().getExtras();

        height = (EditText) findViewById(R.id.height);

        weight = (EditText) findViewById(R.id.weight);
        Name1 = (TextView) findViewById(R.id.name);
      //  Surname1 = (TextView) findViewById(R.id.surname);
       // picture = (CircleImageView) findViewById(R.id.profile_image);

        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");
            String Date =extras.getString("Date");
            String Sex =extras.getString("Sex");
            String City=extras.getString("City");

  //          Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
//            picture.setImageBitmap(bitmap);
            Name1.setText(Name);
    //        Surname1.setText(Surname);
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onCheckStatus();
                onCheckboxClicked(v);
                onRadioButtonClicked(v);

                Intent intent = new Intent(QuestionarieActivity.this, MenuActivity.class);
                intent.putExtra("Name", extras.getString("Name"));
                intent.putExtra("Surname", extras.getString("Surname"));
                intent.putExtra("Email", extras.getString("Email"));
                intent.putExtra("City", extras.getString("City"));
                intent.putExtra("Date", extras.getString("Date"));
         //       picture.buildDrawingCache();
           //     Bitmap bitmap = picture.getDrawingCache();
             //   intent.putExtra("Bitmap", bitmap);

                intent.putExtra("password", extras.getString("password"));
                intent.putExtra( "Sex",extras.getString("Sex"));
                startActivity(intent);

            }
        });

    }
    public void onCheckStatus(){
        String weight_check = weight.getText().toString();
        String height_check = height.getText().toString();


        if (height_check.isEmpty()){

            height.setError("Please enter your height:");
            height.requestFocus();

            Toast.makeText(QuestionarieActivity.this, "Field height is empty", Toast.LENGTH_LONG).show();

        } else  if (weight_check.isEmpty() ) {
            weight.setError("Please enter your weight:");
            weight.requestFocus();

            Toast.makeText(QuestionarieActivity.this, "Field weight is empty", Toast.LENGTH_LONG).show();
        }
        else if(Integer.parseInt(weight_check)<0 )
        {
//Error message for example
            weight.setError("Please enter a valid weight higher than 0:");
            weight.requestFocus();

            Toast.makeText(QuestionarieActivity.this, "Field weight is not correct", Toast.LENGTH_LONG).show();

        }else if(Integer.parseInt(weight_check)<0){
            height.setError("Please enter a valid height:");
            height.requestFocus();

            Toast.makeText(QuestionarieActivity.this, "Field height is not correct", Toast.LENGTH_LONG).show();

        }
        else{
            Height=height_check;
            Weight=weight_check;
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

                    B.setClickable(false);
                    A.setClickable(false);
                }
                    break;
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.Tennis:
                if (checked)
                {           new Thread() {
                        @Override
                        public void run() {
                            preferences.add("Tennis");


                            Set<String> doppione6 = findDuplicates(preferences);
                            if (doppione6.contains("Tennis"))
                                preferences.remove("Tennis");

                        }
                    }.start();

                 }break;
            case R.id.Football:
                if (checked)
                {
                    new Thread() {
                        @Override
                        public void run() {
                            preferences.add("Football");


                            Set<String> doppione5 = findDuplicates(preferences);
                            if (doppione5.contains("Football"))
                                preferences.remove("Football");

                        }
                    }.start();

        }                    break;
            case R.id.Running:
                if (checked)
                {
                    new Thread() {
                        @Override
                        public void run() {
                            preferences.add("Running");


                            Set<String> doppione4 = findDuplicates(preferences);
                            if (doppione4.contains("Running"))
                                preferences.remove("Running");

                        }
                    }.start();

                  }break;
            case R.id.Swimming:
                if (checked){

                    new Thread() {
                        @Override
                        public void run() {

                            preferences.add("Swimming");

                            Set<String> doppione3 = findDuplicates(preferences);
                            if (doppione3.contains("Swimming"))
                                preferences.remove("Swimming");
                        }
                    }.start();

        }break;
            case R.id.Gym:
                if (checked)
                {
                    new Thread() {
                        @Override
                        public void run() {
                            preferences.add("Gym");

                            Set<String> doppione2 = findDuplicates(preferences);
                            if (doppione2.contains("Gym"))
                                preferences.remove("Gym");

                        }
                    }.start();

              } break;
                case R.id.Yoga:
                if (checked) {
                    new Thread() {
                        @Override
                        public void run() {
                            preferences.add("Yoga");
                            Set<String> doppione = findDuplicates(preferences);
                            if (doppione.contains("Yoga"))
                                preferences.remove("Yoga");

                        }
                    }.start();

                       }   break;


        }
    }
    public static Set<String> findDuplicates(List<String> listContainingDuplicates) {

        final Set<String> setToReturn = new HashSet<String>();
        final Set<String> set1 = new HashSet<String>();

        for (String yourInt : listContainingDuplicates) {
            if (!set1.add(yourInt)) {
                setToReturn.add(yourInt);
            }
        }
        return setToReturn;
    }
}

