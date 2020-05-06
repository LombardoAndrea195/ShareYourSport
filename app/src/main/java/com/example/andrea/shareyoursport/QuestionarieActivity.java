package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuestionarieActivity extends AppCompatActivity {
    private Button next;
    private TextView Name1;
    private TextView Surname1;
    private List<String> preferences;
    private CircleImageView picture;
    private CheckBox Tennis,Football,Gym,Yoga,Swimming,Running;
    private RadioButton A,B,C;
    private String Level;
    private Integer Height,Weight;
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
                }
                break;
            case R.id.B:
                if (checked) {
                    Level = "Middle";
                    A.setChecked(false);
                    C.setChecked(false);
                }
                break;
                case R.id.C:
                if (checked){
                    Level="Hard";
                    C.setChecked(false);
                    B.setChecked(false);
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
                preferences.add("Tennis");
                    break;
            case R.id.Football:
                if (checked)
                    preferences.add("Football");

                break;
            case R.id.Running:
                if (checked)
                    preferences.add("Running");

                break;
            case R.id.Swimming:
                if (checked)
                    preferences.add("Swimming");

                break;
                case R.id.Gym:
                if (checked)
                    preferences.add("Gym");

                    break;
                case R.id.Yoga:
                if (checked)
                    preferences.add("Yoga");

                    break;


        }
    }
}
