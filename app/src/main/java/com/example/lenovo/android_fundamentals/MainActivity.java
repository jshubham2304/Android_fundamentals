package com.example.lenovo.android_fundamentals;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class MainActivity extends AppCompatActivity {
        AlarmManager alarmManager;
    MyInternetReceiver myInternetReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
        myInternetReceiver = new MyInternetReceiver();
        registerReceiver();



    }

    private void registerReceiver() {
        try{
            IntentFilter myIntentFilter =  new IntentFilter();myIntentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            myIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
            myIntentFilter.addAction(getPackageName() + "android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(myInternetReceiver,myIntentFilter);

        }catch (Exception E){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myInternetReceiver);
    }

    public void OnAlarm(View view) {

Intent i1 = new Intent();
i1.setAction("com.example.myalarm");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i1,0);
        Toast.makeText(this, "Start Alarm", Toast.LENGTH_SHORT).show();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), 30000,pendingIntent);

    }

    public void StopAlarm(View view) {
        Toast.makeText(this, "Stop Alarm", Toast.LENGTH_SHORT).show();
        Intent i1 = new Intent();
        i1.setAction("com.example.myalarm");
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i1,0);
        alarmManager.cancel(pendingIntent);
    }

    public void StartReciver(View view) {
        Intent intent = new Intent("com.noInternet.service.example");
        Toast.makeText(this, "START BOARDCAST RECIVER", Toast.LENGTH_SHORT).show();
        sendBroadcast(intent);
    }
}
