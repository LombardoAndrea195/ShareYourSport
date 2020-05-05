package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button searchButton,newButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /*
        * Bisognerà configurare 4 casistiche diverse la prima che fa un accesso tramite login classico
        * 1) login basato su Facebook
        * 2) login basato su Google
        * 3) login basato su Registrazione
        * 4) login basato su login normale tutte devono portare a questa activity
        * */
        searchButton=(Button) findViewById(R.id.search_event);

        newButton=(Button) findViewById(R.id.new_event);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, NewEventActivity.class));

            }
        });

     searchButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MenuActivity.this, SearchEventActivity.class));

        }
    });
}
}
