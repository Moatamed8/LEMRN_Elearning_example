package com.example.moatamed.gproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent=new Intent(this,StudentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBulider=new NotificationCompat.Builder(this);
        notificationBulider.setContentTitle("Lemern");
        notificationBulider.setContentText(remoteMessage.getNotification().getBody());
        notificationBulider.setAutoCancel(true);
        notificationBulider.setSmallIcon(R.drawable.lllogo);
        notificationBulider.setDefaults(Notification.DEFAULT_SOUND);
        notificationBulider.setContentIntent(pendingIntent);
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBulider.build());
    }
}
