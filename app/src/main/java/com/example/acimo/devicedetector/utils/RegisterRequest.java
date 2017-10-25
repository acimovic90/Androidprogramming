package com.example.acimo.devicedetector.utils;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acimo on 25-10-2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://adgrego.dk/register.php";
    private Map<String, String> params;
    private static final String TAG = "RegisterRequest";
    public RegisterRequest(String email, String username, String password, Response.Listener<String> listener){ //constructer
        super(Method.POST, REGISTER_REQUEST_URL, listener, null); //Super is the baseclass which is StringRequest
        Log.d(TAG, "inside RegisterRequest we get " + listener);
        params = new HashMap<>();
        params.put("email",email);
        params.put("username",username);
        params.put("password",password);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
