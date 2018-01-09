package com.example.acimo.socialfitness;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.acimo.socialfitness.Webservices.RegisterRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText createEmailText;
    private EditText createUserText;
    private EditText createPasswordText;
    private static final String TAG = "RegisterUserActivity";
    private Button createUserButton;
    public static final String EMAIL_KEY = "email_input";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        createEmailText = (EditText) findViewById(R.id.text_create_email);
        createUserText = (EditText) findViewById(R.id.text_create_username);
        createPasswordText = (EditText) findViewById(R.id.text_create_password);
        createUserButton = (Button) findViewById(R.id.button_create);
        createUserButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String checkEmail = createEmailText.getText().toString();
                String checkUsername = createUserText.getText().toString();
                String checkPassword = createPasswordText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(RegisterUserActivity.this, MainActivity.class);
                                RegisterUserActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterUserActivity.this);
                                builder.setMessage("Register Failed").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(checkEmail, checkUsername, checkPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterUserActivity.this);
                queue.add(registerRequest);

            }
        });
    }
}

