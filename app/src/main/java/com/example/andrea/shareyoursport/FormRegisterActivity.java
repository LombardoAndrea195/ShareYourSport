package com.example.andrea.shareyoursport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class FormRegisterActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    private EditText Firstname;
    private EditText Secondname;
    private EditText E_mail;
    private EditText Password;
    private EditText Password_conf;
    private Button next;
    private FloatingActionButton buttonpicture;
    private CircleImageView picture;
    private Uri imageUri;

    private byte[] byteArray;
    private void openGallery(){
        Intent gallery =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            picture.setImageURI(imageUri);
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.profile_image);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

            byteArray = stream.toByteArray();

        }
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
        picture = (CircleImageView) findViewById(R.id.profile_image);
        buttonpicture = (FloatingActionButton) findViewById(R.id.new_pic);
        Firstname = (EditText) findViewById(R.id.firstname);
        Password_conf = (EditText) findViewById(R.id.confirm_pass);
        next = (Button) findViewById(R.id.submit);
        Secondname = (EditText) findViewById(R.id.secondname);
        Password = (EditText) findViewById(R.id.password);
        E_mail = (EditText) findViewById(R.id.email);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                        SignUpAccount();



            }
        });


        buttonpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }


        });


    }
    public void SignUpAccount() {
        String email_check = E_mail.getText().toString();
        String password_check = Password.getText().toString();

        String passwordconfirm_check = Password_conf.getText().toString();
        String Secondname_check = Secondname.getText().toString();
        String Firstname_check = Firstname.getText().toString();

        if (email_check.isEmpty()) {
            E_mail.setError("Please enter your email:");
            E_mail.requestFocus();

            Toast.makeText(FormRegisterActivity.this, "Field is empty", Toast.LENGTH_LONG).show();
        } else if (password_check.isEmpty() || passwordconfirm_check.isEmpty()) {

            Password.setError("Please enter your password:");
            Password.requestFocus();
            Password_conf.setError("Please enter your password");
            Password_conf.requestFocus();

            Toast.makeText(FormRegisterActivity.this, "Fields password is empty", Toast.LENGTH_LONG).show();

        } else if (Secondname_check.isEmpty()) {
            Secondname.setError("Please enter your second name");
            Secondname.requestFocus();

            Toast.makeText(FormRegisterActivity.this, "Field Last name is empty", Toast.LENGTH_LONG).show();

        } else if (Firstname_check.isEmpty()) {
            Firstname.setError("Please enter your first name");
            Firstname.requestFocus();

            Toast.makeText(FormRegisterActivity.this, "Fields First name is empty", Toast.LENGTH_LONG).show();

        } else if (!password_check.contentEquals(passwordconfirm_check)) {
            Password.setError("Password are not the same:");
            Password.requestFocus();
            Password_conf.setError("Password are not the same");
            Password_conf.requestFocus();


            Toast.makeText(FormRegisterActivity.this, "Fields password is empty", Toast.LENGTH_LONG).show();


        }
        else{
        Intent intent = new Intent(FormRegisterActivity.this, SecondActivity.class);

        intent.putExtra("Name", Firstname_check);
        intent.putExtra("Surname", Secondname_check);
        intent.putExtra("Email", email_check);
        intent.putExtra("picture", byteArray);
        intent.putExtra("password", password_check);
        startActivity(intent);
    }}



}



