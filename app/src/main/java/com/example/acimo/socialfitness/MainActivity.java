package com.example.acimo.socialfitness;
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
import com.example.acimo.socialfitness.Webservices.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText loginUsernameText;
    private EditText loginPasswordText;
    private Button loginButton;
    private TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUsernameText = (EditText) findViewById(R.id.text_login_username);
        loginPasswordText = (EditText) findViewById(R.id.text_login_password);
        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = (TextView) findViewById(R.id.button_register_text);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String checkUsernameLogin = loginUsernameText.getText().toString();
                final String checkPasswordLogin = loginPasswordText.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String email = jsonResponse.getString("email");
                                Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
                                intent.putExtra("email", email);
                                intent.putExtra("username", checkUsernameLogin);
                                intent.putExtra("password", checkPasswordLogin);
                                MainActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login Failed").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(checkUsernameLogin, checkPasswordLogin, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterUserActivity.class);
                startActivity(intent);
            }
        });
    }
}


