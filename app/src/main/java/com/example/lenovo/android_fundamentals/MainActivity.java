package com.example.lenovo.android_fundamentals;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class MainActivity extends AppCompatActivity {

    MyInternetReceiver myInternetReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myInternetReceiver = new MyInternetReceiver();
        registerReceiver();
    }

    private void registerReceiver() {
        try{
            IntentFilter myIntentFilter =  new IntentFilter();myIntentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            myIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);

            registerReceiver(myInternetReceiver,myIntentFilter);

        }catch (Exception E){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myInternetReceiver);
    }
}
