package com.example.andrea.shareyoursport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

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

    }
}
