package com.example.acimo.devicedetector;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_login);
        signupButton = (Button) findViewById(R.id.button_signup);
    }

    public void signup(View view){
        Intent intent = new Intent(this, SignupAcivity.class);
        startActivity(intent);
    }


}
