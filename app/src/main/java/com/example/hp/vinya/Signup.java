package com.example.hp.vinya;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.vinya.Data.AppDatabase;
import com.example.hp.vinya.Data.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.SQLException;
import java.sql.SQLNonTransientException;

import javax.microedition.khronos.egl.EGLDisplay;

public class Signup extends AppCompatActivity {
    EditText emailText, mobilenoText, passwordText;
    AppDatabase database;
    User user = new User();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailText = (EditText) findViewById(R.id.email);
        mobilenoText = (EditText) findViewById(R.id.contact);
        passwordText = (EditText) findViewById(R.id.password);
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User").allowMainThreadQueries().build();
    }

    void signup(View view) {
        try {
            firebaseDatabase = FirebaseDatabase.getInstance();
            myRef= firebaseDatabase.getReference("Users");
            String password, email, mobileno;
            Long mobileno1;
            mobileno = mobilenoText.getText().toString();
            mobileno1 = Long.parseLong(mobileno);
            password = passwordText.getText().toString();
            email = emailText.getText().toString();

            user.setMobileno(mobileno1);
            user.setEmail(email);
            user.setPassword(password);
            database.userDao().insertAll(user);
            myRef.push().setValue(user);

            int length = Toast.LENGTH_SHORT;
            String msg = "inserted";
            Toast t = Toast.makeText(this, msg, length);
            t.show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        } catch (SQLiteConstraintException e) {
            int length = Toast.LENGTH_SHORT;
            String msg = "invalid";
            Toast t = Toast.makeText(this, msg, length);
            t.show();
        }
    }
}
        //Intent intent = new Intent(this,MainActivity.class);
        //startActivity(intent);



