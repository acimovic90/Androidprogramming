package com.example.acimo.socialfitness.Webservices;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class UpdateRequest extends StringRequest{
    private static final String UPDATE_REQUEST_URL = "http://adgrego.dk/update.php";
    private Map<String, String> params;
    private static final String TAG = "UpdateRequest";
    public UpdateRequest(String email, String username, String password, Response.Listener<String> listener){
        super(Request.Method.POST, UPDATE_REQUEST_URL, listener, null);
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


