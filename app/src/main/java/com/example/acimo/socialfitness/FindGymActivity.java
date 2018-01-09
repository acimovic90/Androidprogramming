package com.example.acimo.socialfitness;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.acimo.socialfitness.models.FitnessGymsModel;
import java.util.ArrayList;


public class FindGymActivity extends AppCompatActivity {
    private TextView showGymsList;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gym);
        context = this.getBaseContext();
        showGymsList = (TextView) findViewById(R.id.list_gyms_text);
        Bundle extra = getIntent().getBundleExtra("extra");
        final ArrayList<FitnessGymsModel> objects = (ArrayList<FitnessGymsModel>) extra.getSerializable("objects");
        for(int i =0; i < objects.size(); i++){
            showGymsList.append(objects.get(i).getAdress1() + "\n"+"\n");
        }

    }
}




