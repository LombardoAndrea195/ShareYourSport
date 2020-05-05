package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class FinishRegistrationActivity extends AppCompatActivity {

    private Button next;
    private CircleImageView picture;
    private Uri imageUri;

    private static final int PICK_IMAGE = 100;
     private TextView Name1;
    private TextView Surname1;
      private String Sex;
    public java.util.Date validateDateFormat(String dateToValdate) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HHmmss");
        //To make strict date format validation
        formatter.setLenient(false);
        java.util.Date parsedDate = null;
        try {
            parsedDate = formatter.parse(dateToValdate);
            System.out.println("++validated DATE TIME ++"+formatter.format(parsedDate));

        } catch (ParseException e) {
            //Handle exception
        }
        return parsedDate;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_finish_registration);
        Bundle extras = getIntent().getExtras();
        Name1 = (TextView) findViewById(R.id.name);
        Surname1 = (TextView) findViewById(R.id.surname);
        picture = (CircleImageView) findViewById(R.id.profile_image);

        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");
            int valueUri = extras.getInt("picture");
            String Date =extras.getString("Date");
            String Sex =extras.getString("Sex");
            String City=extras.getString("City");

            Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
            picture.setImageBitmap(bitmap);
            Name1.setText(Name);
            Surname1.setText(Surname);
            next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







                Date birthday = validateDateFormat(Date.toString());

                new Thread()
                {
                    @Override
                    public void run()
                    {
                       /*Creazione di un profilo e storage interno*/

                            Utente_Entity utenteNew = new Utente_Entity(birthday, Name, Surname, email, Sex, password, City);

                        Utente_Entity utenteNew2 = new Utente_Entity(birthday, Name, Surname, email, Sex, password, City, bitmap);
                    }
                }.start();


                Intent intent = new Intent(FinishRegistrationActivity.this, MenuActivity.class);
                intent.putExtra("Name", extras.getString("Name"));
                intent.putExtra("Surname", extras.getString("Surname"));
                intent.putExtra("Email", extras.getString("Email"));
                intent.putExtra("City", extras.getString("City"));
                intent.putExtra("Date", extras.getString("Date"));
                picture.buildDrawingCache();
                Bitmap bitmap = picture.getDrawingCache();
                intent.putExtra("Bitmap", bitmap);

                intent.putExtra("password", extras.getString("password"));
                intent.putExtra( "Sex",Sex);
                startActivity(intent);

            }
        });

    }

    }
}