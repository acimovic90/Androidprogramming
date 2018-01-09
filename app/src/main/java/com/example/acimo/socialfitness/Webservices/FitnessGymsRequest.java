package com.example.acimo.socialfitness.Webservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.acimo.socialfitness.FindGymActivity;
import com.example.acimo.socialfitness.models.FitnessGymsModel;
import com.example.acimo.socialfitness.models.ListFitnessGymsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FitnessGymsRequest {
    private static final String FITNESS_REQUEST_URL = "https://www.fitnessworld.com/dk/api/v1.0.0/centers";
    private FitnessGymsModel fitnessGymsModel;
    private ListFitnessGymsModel listFitnessGymsModel;
    View view;

    public FitnessGymsRequest(RequestQueue requestQueue){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, FITNESS_REQUEST_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONObject("data").getJSONArray("list");
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
                    Bundle extra = new Bundle();
                    extra.putSerializable("objects", listFitnessGymsModel.FitnessList);
                    Intent intent = new Intent(view.getContext(),FindGymActivity.class);
                    intent.putExtra("extra", extra);
                    view.getContext().startActivity(intent);
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



