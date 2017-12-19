package com.acherniakovich.android.windowcalculate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.acherniakovich.android.windowcalculate.fragments.Mosquito_nets;
import com.acherniakovich.android.windowcalculate.fragments.Slopes;
import com.acherniakovich.android.windowcalculate.fragments.Windows_sills;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "MyLogs";

    private TextView TAB_slopes,TAB_window_sill,TAB_mosquito_net;
    private Fragment fragmentTABSlopes,fragmentTABWindowsSills,fragmentTABMosquitoNet;
    private FragmentTransaction fragmentTransaction;
    private FrameLayout container_for_fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        container_for_fragments = (FrameLayout) findViewById(R.id.container_for_fragments);

        TAB_slopes = (TextView)findViewById(R.id.TAB_slopes);
        TAB_window_sill = (TextView)findViewById(R.id.TAB_window_sill);
        TAB_mosquito_net = (TextView)findViewById(R.id.TAB_mosquito_net);

        fragmentTABSlopes = new Slopes();
        fragmentTABWindowsSills = new Windows_sills();
        fragmentTABMosquitoNet = new Mosquito_nets();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_for_fragments,fragmentTABSlopes);
        fragmentTransaction.commit();
    }

    public void onClick(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.TAB_slopes:
                //Log.d(LOG_TAG,"TAB_slopes");
                // press tab slopes
                setBackgroundDrawable(TAB_slopes);
                fragmentTransaction.replace(R.id.container_for_fragments,fragmentTABSlopes);
                break;
            case R.id.TAB_window_sill:
                //Log.d(LOG_TAG,"TAB_window_sill");
                // press tab windows sill
                setBackgroundDrawable(TAB_window_sill);
                fragmentTransaction.replace(R.id.container_for_fragments,fragmentTABWindowsSills);
                break;
            case R.id.TAB_mosquito_net:
                //Log.d(LOG_TAG,"TAB_mosquito_net");
                // press tab mosquito net
                setBackgroundDrawable(TAB_mosquito_net);
                fragmentTransaction.replace(R.id.container_for_fragments,fragmentTABMosquitoNet);
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

    private void setBackgroundDrawable(View v){
        if (v==TAB_slopes){
            TAB_slopes.setBackgroundResource(R.drawable.yellow_background);
            TAB_window_sill.setBackgroundResource(0);
            TAB_mosquito_net.setBackgroundResource(0);
        }else if (v==TAB_window_sill){
            TAB_slopes.setBackgroundResource(0);
            TAB_window_sill.setBackgroundResource(R.drawable.yellow_background);
            TAB_mosquito_net.setBackgroundResource(0);
        }else if (v==TAB_mosquito_net){
            TAB_slopes.setBackgroundResource(0);
            TAB_window_sill.setBackgroundResource(0);
            TAB_mosquito_net.setBackgroundResource(R.drawable.yellow_background);
        }
    }

}
