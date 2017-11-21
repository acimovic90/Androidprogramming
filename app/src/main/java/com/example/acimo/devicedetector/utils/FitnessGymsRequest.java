package com.example.acimo.devicedetector.utils;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.acimo.devicedetector.models.FitnessGymsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FitnessGymsRequest { //Fejl opstår herfra
    private static final String FITNESS_REQUEST_URL = "https://www.fitnessworld.com/dk/api/v1.0.0/centers";
    private FitnessGymsModel fitnessGymsModel;
    public FitnessGymsRequest(){ //constructer
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, FITNESS_REQUEST_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data").getJSONArray(0);
                   // JSONObject j = (JSONObject) jsonArray.get(1);
                   //j.getJSONArray("list");
                   // FitnessGymsModel fitnessGymsModel = new FitnessGymsModel();
                    //Create new arraylist
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject j = (JSONObject) jsonArray.get(i);
                       // mylist.add(new FitnessGymsModel())
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
