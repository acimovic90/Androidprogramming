package com.example.acimo.devicedetector;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupAcivity extends AppCompatActivity {

    private EditText createEmailText;
    private EditText createUserText;
    private EditText createPasswordText;
    private Button createUserButton;
    public static final String EMAIL_KEY = "email_input";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_acivity);

        createEmailText = (EditText) findViewById(R.id.text_create_email);
        createUserText = (EditText) findViewById(R.id.text_create_username);
        createPasswordText = (EditText) findViewById(R.id.text_create_password);
        createUserButton = (Button) findViewById(R.id.button_create);
        createUserButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SignupAcivity.this, CreateUserActivity.class);
                intent.putExtra(EMAIL_KEY, createEmailText.getText().toString());
                startActivity(intent);
            }
        });


        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String checkUsername = createUserText.getText().toString();
                String checkPassword = createPasswordText.getText().toString();
                runner.execute(sleepTime);
            }
        });
    }

    private class AsyncTaskRunner {
    }
}
