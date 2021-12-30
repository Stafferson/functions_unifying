package com.example.functions_unifying.notifications_reader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.functions_unifying.R;

public class Notification_reading extends AppCompatActivity implements MyListener {
    private TextView txtView ;
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_notification_reading);
        new NotificationService().setListener(this);
        txtView = findViewById(R.id.textView);
        Context context = getApplicationContext();
        System.out.println("ghj");
        System.out.println(context);
        Button btnCreateNotification = findViewById(R.id.btnCreateNotification ) ;
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                NotificationManager mNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE ) ;
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(Notification_reading.this, default_notification_channel_id ) ;
                mBuilder.setContentTitle("My Notification");
                mBuilder.setContentText("Notification Listener Service Example");
                mBuilder.setTicker("Notification Listener Service Example");
                mBuilder.setSmallIcon(R.drawable. ic_launcher_foreground);
                mBuilder.setAutoCancel(true);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    int importance = NotificationManager. IMPORTANCE_HIGH;
                    NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
                    mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID );
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel);
                }
                assert mNotificationManager != null;
                mNotificationManager.notify((int)System.currentTimeMillis(),mBuilder.build());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu. menu_main , menu) ; //Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id. action_settings :
                Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS" ) ;
                startActivity(intent) ;
                return true;
            default :
                return super .onOptionsItemSelected(item) ;
        }
    }
    @Override
    public void setValue (String packageName) {
        txtView .append( " \n " + packageName) ;
    }
}