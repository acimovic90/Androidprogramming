package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {
    private TextView updateTitleText;
    private EditText updateEmailText;
    private EditText updateUsernameText;
    private EditText updatePasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        updateTitleText = (TextView) findViewById(R.id.text_update_title);
        updateEmailText = (EditText) findViewById(R.id.text_update_email);
        updateUsernameText = (EditText) findViewById(R.id.text_update_username);
        updatePasswordText = (EditText) findViewById(R.id.text_update_password);

        Intent intent = getIntent();
        String updateEmail = intent.getStringExtra("email");
        String updateUsername = intent.getStringExtra("username");
        String updatePassword = intent.getStringExtra("password");

        updateTitleText.setText("Welcome " + updateUsername);
        updateEmailText.setText(updateEmail);
        updateUsernameText.setText(updateUsername);
        updatePasswordText.setText(updatePassword);
    }
}
