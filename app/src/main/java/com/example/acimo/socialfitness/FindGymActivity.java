package com.example.acimo.socialfitness;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.acimo.socialfitness.models.FitnessGymsModel;
import com.example.acimo.socialfitness.models.ListFitnessGymsModel;
import com.example.acimo.socialfitness.Webservices.FitnessGymsRequest;
import java.util.ArrayList;


public class FindGymActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    FitnessGymsRequest fitnessGymsRequest;
    ListFitnessGymsModel listFitnessGymsModel;
    private Button buttonShowGymList;
    private TextView showGymsList;
    Bundle bundle;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gym);
        context = this.getBaseContext();
        requestQueue = Volley.newRequestQueue(FindGymActivity.this);
        buttonShowGymList = (Button) findViewById(R.id.button_get_gyms);
        showGymsList = (TextView) findViewById(R.id.list_gyms_text);
        fitnessGymsRequest = new FitnessGymsRequest(requestQueue);

        buttonShowGymList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle extra = getIntent().getBundleExtra("extra");
                final ArrayList<FitnessGymsModel> objects = (ArrayList<FitnessGymsModel>) extra.getSerializable("objects");
                for(int i =0; i < objects.size(); i++){
                    showGymsList.append(objects.get(i) + "\n");
                }

            }
        });
    }
}




