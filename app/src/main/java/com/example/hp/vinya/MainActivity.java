package com.example.hp.vinya;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.vinya.Data.AppDatabase;

public class MainActivity extends AppCompatActivity {
AppDatabase database;
EditText mobnoText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "User").allowMainThreadQueries().build();
        mobnoText = (EditText)findViewById(R.id.contact_id);
        passwordText= (EditText)findViewById(R.id.password_id);

}
    void login(View v)
    {
        String conatact,password;

        conatact = mobnoText.getText().toString();
        password = passwordText.getText().toString();
        long mobileno =Long.parseLong(conatact);
        boolean i =database.userDao().getauth(mobileno,password);
        if(i==true)
        {

            Intent intent;
            intent = new Intent(this, Main2Activity.class);
            startActivity(intent);

        }
        else {
            int length = Toast.LENGTH_SHORT;
            String msg="invalid login";
            Toast toast = Toast.makeText(this,msg,length);
            toast.show();
        }
    }
    void signup(View view)
    {
        Intent intent;
        intent = new Intent(this,Signup.class);
        startActivity(intent);
    }


}
