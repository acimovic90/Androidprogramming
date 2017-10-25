package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_login);
        signupButton = (Button) findViewById(R.id.button_signup);
    }

    public void LoginUser(View view){
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    public void SignupUser(View view){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
    }


}
