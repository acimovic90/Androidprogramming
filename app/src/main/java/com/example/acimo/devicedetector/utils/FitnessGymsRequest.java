package com.example.acimo.devicedetector.utils;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.acimo.devicedetector.models.FitnessGymsModel;
import com.example.acimo.devicedetector.models.ListFitnessGymsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FitnessGymsRequest { //Fejl opstår herfra
    private static final String FITNESS_REQUEST_URL = "https://www.fitnessworld.com/dk/api/v1.0.0/centers";
    private FitnessGymsModel fitnessGymsModel;
    private ListFitnessGymsModel listFitnessGymsModel;
    public FitnessGymsRequest(RequestQueue requestQueue){ //constructer
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, FITNESS_REQUEST_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONArray jsonArray = response.getJSONArray("data").getJSONArray(0);
                    JSONArray jsonArray = response.getJSONObject("data").getJSONArray("list"); //Hjælp til dette!!
                    //List<FitnessGymsModel> gymList = new ArrayList<>();
                    listFitnessGymsModel = new ListFitnessGymsModel();
                    for(int i = 0; i < jsonArray.length(); i++){
                        fitnessGymsModel = new FitnessGymsModel();
                        JSONObject j = (JSONObject) jsonArray.get(i);
                        Log.d("showId", ""+j.getInt("id"));
                        fitnessGymsModel.setId(j.getInt("id"));
                        fitnessGymsModel.setActive(j.getInt("active"));
                        fitnessGymsModel.setAdress1(j.getString("adress1"));
                        fitnessGymsModel.setAdress2(j.getString("adress2"));
                        fitnessGymsModel.setCity(j.getString("city"));
                        fitnessGymsModel.setZip(j.getString("zip"));
                        fitnessGymsModel.setCountry(j.getString("country"));
                        listFitnessGymsModel.FitnessList.add(fitnessGymsModel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", "ERROR");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
