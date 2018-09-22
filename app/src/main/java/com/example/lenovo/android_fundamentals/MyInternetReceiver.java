package com.example.lenovo.android_fundamentals;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyInternetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
            Toast.makeText(context, "Airplane Mode ", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
            Toast.makeText(context, "Power On", Toast.LENGTH_SHORT).show();
        if(intent.getAction().equals("com.noInternet.service.example"))
        {    Toast.makeText(context, "Inside the Internet service", Toast.LENGTH_SHORT).show();
//                   ConnectivityManager cm =
//                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        boolean isConnected = activeNetwork != null &&
//                activeNetwork.isConnectedOrConnecting();
//        if (isConnected) {
//            try {
//                Toast.makeText(context, "Network is connected", Toast.LENGTH_LONG).show();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            Toast.makeText(context, "Network is changed or reconnected", Toast.LENGTH_LONG).show();
//        }
    }
}

    }

