package com.example.acimo.devicedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.acimo.devicedetector.utils.FitnessGymsRequest;
import com.example.acimo.devicedetector.utils.LoginRequest;

public class FindGymActivity extends AppCompatActivity {
    private ListView showGymsList;
    private RequestQueue requestQueue;
    private FitnessGymsRequest fitnessGymsRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gym);
        showGymsList = (ListView) findViewById(R.id.list_show_gyms);
        requestQueue = Volley.newRequestQueue(this);
        fitnessGymsRequest = new FitnessGymsRequest();
    }

    public void sendJSrequest(){


    }
}
