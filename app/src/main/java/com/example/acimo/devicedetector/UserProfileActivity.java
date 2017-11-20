package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.acimo.devicedetector.utils.LoginRequest;
import com.example.acimo.devicedetector.utils.UpdateRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class UserProfileActivity extends AppCompatActivity {
    private TextView updateTitleText;
    private EditText updateEmailText;
    private EditText updateUsernameText;
    private EditText updatePasswordText;
    private Button updateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        updateTitleText = (TextView) findViewById(R.id.text_update_title);
        updateEmailText = (EditText) findViewById(R.id.text_update_email);
        updateUsernameText = (EditText) findViewById(R.id.text_update_username);
        updatePasswordText = (EditText) findViewById(R.id.text_update_password);
        updateButton = (Button) findViewById(R.id.button_update);

        Intent intent = getIntent();
        String updateEmail = intent.getStringExtra("email");
        String updateUsername = intent.getStringExtra("username");
        String updatePassword = intent.getStringExtra("password");

        updateTitleText.setText("Welcome " + updateUsername);
        updateEmailText.setText(updateEmail);
        updateUsernameText.setText(updateUsername);
        updatePasswordText.setText(updatePassword);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String checkEmailUpdate = updateEmailText.getText().toString();
                final String checkUsernameUpdate = updateUsernameText.getText().toString();
                final String checkPasswordUpdate = updatePasswordText.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfileActivity.this);
                                builder.setMessage("User Update Success").setPositiveButton("Ok", null).create().show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfileActivity.this);
                                builder.setMessage("User Update Failed").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                UpdateRequest updateRequest = new UpdateRequest(checkEmailUpdate, checkUsernameUpdate, checkPasswordUpdate, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserProfileActivity.this);
                queue.add(updateRequest);

            }
        });
    }
}
