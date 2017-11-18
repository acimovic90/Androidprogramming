package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class UserProfileActivity extends AppCompatActivity {
    private EditText updateEmailText;
    private EditText updateUsernameText;
    private EditText updatePasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        updateEmailText = (EditText) findViewById(R.id.text_update_email);
        updateUsernameText = (EditText) findViewById(R.id.text_update_username);
        updatePasswordText = (EditText) findViewById(R.id.text_update_password);

        Intent intent = getIntent();
        String updateEmail = intent.getStringExtra("email");
        String updateUsername = intent.getStringExtra("username");
        String updatePassword = intent.getStringExtra("password");

        updateEmailText.setText(updateEmail);
        updateUsernameText.setText(updateUsername);
        updatePasswordText.setText(updatePassword);
    }
}
