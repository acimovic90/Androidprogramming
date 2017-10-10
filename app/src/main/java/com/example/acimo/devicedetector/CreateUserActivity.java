package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        Intent intent = getIntent();
        String email = intent.getStringExtra(SignupAcivity.EMAIL_KEY);
        TextView tv = (TextView) findViewById(R.id.showMailText);
        tv.setText(email);
    }
}
