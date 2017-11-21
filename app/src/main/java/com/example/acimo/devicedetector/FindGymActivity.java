package com.example.acimo.devicedetector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.acimo.devicedetector.models.FitnessGymsModel;
import com.example.acimo.devicedetector.models.ListFitnessGymsModel;
import com.example.acimo.devicedetector.utils.FitnessGymsRequest;
import com.example.acimo.devicedetector.utils.LoginRequest;

public class FindGymActivity extends AppCompatActivity {
    private ListView showGymsList;
    RequestQueue requestQueue;
    FitnessGymsRequest fitnessGymsRequest;
    private Button getGymsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gym);
        showGymsList = (ListView) findViewById(R.id.list_show_gyms);
        getGymsButton = (Button) findViewById(R.id.button_get_gyms);




        getGymsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                requestQueue = Volley.newRequestQueue(FindGymActivity.this);
                fitnessGymsRequest = new FitnessGymsRequest(requestQueue);
                FitnessGymsModel fitnessGymsModel = new FitnessGymsModel();
                fitnessGymsModel.getAdress1();

            }
        });
    }




}
