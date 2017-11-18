package com.example.acimo.devicedetector.utils;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acimo on 18-11-2017.
 */

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "http://adgrego.dk/login.php";
    private Map<String, String> params;
    private static final String TAG = "LoginRequest";
    public LoginRequest(String username, String password, Response.Listener<String> listener){ //constructer
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null); //Super is the baseclass which is StringRequest
        Log.d(TAG, "inside LoginRequest we get " + listener);
        params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }
    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
