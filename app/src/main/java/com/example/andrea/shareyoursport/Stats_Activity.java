package com.example.andrea.shareyoursport;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class Stats_Activity extends AppCompatActivity {
    private Button next;
    private TextView Name1;
    private TextView Surname1;
    private TextView nEvent,nHours,nCreated;

    private CircleImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_);

            nEvent=(TextView)findViewById(R.id.EventParticipated);
            nCreated=(TextView)findViewById(R.id.EventCreated);
            nHours=(TextView) findViewById(R.id.trained);
            Bundle extras = getIntent().getExtras();
            Name1 = (TextView) findViewById(R.id.name);
            Surname1 = (TextView) findViewById(R.id.surname);
            picture = (CircleImageView) findViewById(R.id.profile_image);
            if (extras != null) {
                String email = extras.getString("Email");
                String Name = extras.getString("Name");
                String Surname = extras.getString("Surname");

                Bitmap bitmap = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");
                picture.setImageBitmap(bitmap);
                Name1.setText(Name);
                Surname1.setText(Surname);

                /*
                Bisogna fare query e poi i seguenti comandi
                nEvent.setText(Stringa)
                nCreated.setText(Stringa)
                nHours.setText(STringa)
                 */
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {






 /*
                scommentare manetendo riferimento del nome cognome email e immagine
                        Intent intent = new Intent( MenuActivity.class);
                        intent.putExtra("Name", extras.getString("Name"));
                        intent.putExtra("Surname", extras.getString("Surname"));
                        intent.putExtra("Email", extras.getString("Email"));
                        startActivity(intent);
*/
                    }
                });

            }

    }
}
