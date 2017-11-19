package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.acimo.devicedetector.utils.RegisterRequest;

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
                            Log.i(TAG, response); //Check the response
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
                /*AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute(checkEmail, checkUsername, checkPassword); //Smider et array og skal matche den datatype AsyncTask har*/

            }
        });


    }
    /*
    class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) { //works in the background
            for (String userInfo: strings) {
                    publishProgress(userInfo);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... params) { //works in the foreground
            super.onProgressUpdate(params);
            if(params[0].length() > 5){
                postData(params[0]); //Min metode til at håndtere postData
            }else{
                Context context = getApplicationContext();
                CharSequence text = "Din infomationer skal være længere!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        }

        @Override
        protected void onPostExecute(String s) { //når man skal lave et webservice kald
            super.onPostExecute(s);
        }
    }

    public void postData(String postData) { //kald webservice her

    }
    */

}
