package com.example.andrea.shareyoursport;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class Configuration_Statistics extends AppCompatActivity {

    private Switch AlertEvent,AlertJoin;



    private Switch Runtastic,Freeletics;

    private String Name,Surname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_statistics);

        Bundle extras = getIntent().getExtras();
//        Name1 = (TextView)findViewById(R.id.name);
  //      Surname1 = (TextView) findViewById(R.id.surname);

        AlertEvent = (Switch) findViewById(R.id.newEvent);
        AlertJoin = (Switch) findViewById(R.id.notifica);
        Runtastic = (Switch) findViewById(R.id.Runtastic);
        Freeletics = (Switch) findViewById(R.id.Freeletics);
        //picture = (CircleImageView) findViewById(R.id.profile_image);

        /*if (extras != null) {
           email = extras.getString("Email");
            Name = extras.getString("Name");
            Surname = extras.getString("Surname");
            password = extras.getString("password");


            Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
            picture.setImageBitmap(bitmap);


            Name1.setText(Name);
            Surname1.setText(Surname);
        }

*/
    checkSwitch();
    }


    private void checkSwitch() {

        AlertEvent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    /*
                     * Alert notifica
                     * */
                    ;
                }
            }
        });
        AlertJoin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    /*
                     * Alert per join event
                     * */
                    ;
                }
            }
        });
        Runtastic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    /*
                     * Fai scambio di dati con Runstatic
                     * */
                    ;
                }
            }
        });

        Freeletics.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    /*
                     * Fai scambio di dati con Freeletics
                     * */
                    ;
                }
            }
        });
    }
}
