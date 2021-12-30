package com.example.functions_unifying.notifications_reader;

import android.content.Context;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class NotificationService extends NotificationListenerService {
    private String TAG = this.getClass().getSimpleName();
    Context context;
    static MyListener myListener;
    static int a;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Log.i(TAG, "********** onNotificationPosted");
        Log.i(TAG, "ID :" + sbn.getId() + " \t " + sbn.getNotification().tickerText + " \t " + sbn.getPackageName());
        myListener.setValue("Post: " + sbn.getPackageName());
        System.out.println(sbn.getNotification().tickerText + "   |   " + sbn.getPackageName() + "   |   " + sbn.toString());
        Log.i(TAG, "gay");
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.i(TAG, "********** onNotificationRemoved");
        Log.i(TAG, "ID :" + sbn.getId() + " \t " + sbn.getNotification().tickerText + " \t " + sbn.getPackageName());
        myListener.setValue("Remove: " + sbn.getPackageName());
    }

    public void setListener(MyListener myListener1) {
        myListener = myListener1;
    }
    /*public void setListener(MyListener myListener) {
        NotificationService.myListener = myListener;
    }*/
}
