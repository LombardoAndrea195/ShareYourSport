package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewEventActivity extends AppCompatActivity {
    private Button next;
    private TextView Name1;
    private TextView Surname1;

    private RadioButton A,B,C;
    private String Level;

    private CircleImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        Bundle extras = getIntent().getExtras();
        Name1 = (TextView) findViewById(R.id.name);
        Surname1 = (TextView) findViewById(R.id.surname);
        picture = (CircleImageView) findViewById(R.id.profile_image);

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
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    onRadioButtonClicked(v);





                    Intent intent = new Intent(NewEventActivity.this, MenuActivity.class);
                    intent.putExtra("Name", extras.getString("Name"));
                    intent.putExtra("Surname", extras.getString("Surname"));
                    intent.putExtra("Email", extras.getString("Email"));
                    intent.putExtra("City", extras.getString("City"));
                    intent.putExtra("Date", extras.getString("Date"));
                    picture.buildDrawingCache();
                    Bitmap bitmap = picture.getDrawingCache();
                    intent.putExtra("Bitmap", bitmap);

                    intent.putExtra("password", extras.getString("password"));
                    intent.putExtra("Sex", Sex);
                    startActivity(intent);

                }
            });

        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.A:
                if (checked)
                    Level = "Easy";

                break;
            case R.id.C:
                if (checked)
                    Level = "Middle";

                break;
            case R.id.B:
                if (checked)
                    Level = "Hard";
                break;
        }
    }}