package com.example.lenovo.android_fundamentals;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class MyAlarmMangerReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "RECIVER THE ALARM", Toast.LENGTH_SHORT).show();
        NotificationManagerCompat  managerCompat = NotificationManagerCompat.from(context);
        NotificationCompat.Builder mynotify = new NotificationCompat.Builder(context);
        mynotify.setContentTitle("Stand Up!");
        mynotify.setContentText("Alarm is Set for 15 min");
        Intent intent1 = new Intent(context,MainActivity.class);
        PendingIntent pd  = PendingIntent.getActivity(context,0,intent1,0);
        mynotify.setContentIntent(pd);
        mynotify.setAutoCancel(true);
        managerCompat.notify(1,mynotify.build());
    }
}
