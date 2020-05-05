package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class PreQuestionarieActivity extends AppCompatActivity {
    private Button next;
    private TextView Name1;
    private TextView Surname1;

    private CircleImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_questionarie);

        next=(Button) findViewById(R.id.next);
        Bundle extras = getIntent().getExtras();
      //  Name1 = (TextView) findViewById(R.id.name);
       // Surname1 = (TextView) findViewById(R.id.surname);
        //picture = (CircleImageView) findViewById(R.id.profile_image);

        if (extras != null) {
            String email = extras.getString("Email");
            String Name = extras.getString("Name");
            String Surname = extras.getString("Surname");
            String password = extras.getString("password");
            String Date =extras.getString("Date");
            String Sex =extras.getString("Sex");
            String City=extras.getString("City");


//            Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
//            picture.setImageBitmap(bitmap);
  //          Name1.setText(Name);
    //        Surname1.setText(Surname);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                Intent intent = new Intent(PreQuestionarieActivity.this, QuestionarieActivity.class);
                intent.putExtra("Name", extras.getString("Name"));
                intent.putExtra("Surname", extras.getString("Surname"));
                intent.putExtra("Email", extras.getString("Email"));
                intent.putExtra("City", extras.getString("City"));
                intent.putExtra("Date", extras.getString("Date"));
      //          picture.buildDrawingCache();
    //            Bitmap bitmap = picture.getDrawingCache();
  //              intent.putExtra("Bitmap", bitmap);

                intent.putExtra("password", extras.getString("password"));
                intent.putExtra( "Sex",extras.getString("Sex"));
                startActivity(intent);

            }
        });

    }


}
