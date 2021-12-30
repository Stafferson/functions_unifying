package com.example.functions_unifying;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.functions_unifying.admin.Admin;
import com.example.functions_unifying.blocking_calls.Call_blocking;
import com.example.functions_unifying.call_history.Call_history;
import com.example.functions_unifying.layout_above_everything.Layout_above_others;
import com.example.functions_unifying.notifications_reader.Notification_reading;

public class MainActivity extends AppCompatActivity {

    ///administrator
    private static final int REQUEST_CODE = 0;
    private DevicePolicyManager mDPM;
    private ComponentName mAdminName;
    ///

    Button b1_2, bt3, bt4, bt5, bt6, bt7, bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///admin
        try
        {
            // Initiate DevicePolicyManager.
            mDPM = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
            // Set DeviceAdminDemo Receiver for active the component with different option
            mAdminName = new ComponentName(this, Admin.class);

            if (!mDPM.isAdminActive(mAdminName)) {
                // try to become active
                Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminName);
                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Click on Activate button to secure your application.");
                startActivityForResult(intent, REQUEST_CODE);
            }
            else
            {
                // Already is a device administrator, can do security operations now.
                mDPM.lockNow();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        ///

        b1_2 = findViewById(R.id.button_1_2_notification);
        bt3 = findViewById(R.id.button_3_call_history);
        bt4 = findViewById(R.id.button_4_numbers_and_etc);
        bt5 = findViewById(R.id.button_5_view_above);
        bt6 = findViewById(R.id.button_6_call_rejection);
        bt7 = findViewById(R.id.button_7_call_recording);
        bt8 = findViewById(R.id.button_8_sms_filtration);

    }

    public void onClick(View view) {
        if (view.getId() == b1_2.getId()) {
            System.out.println("bt1-2");
            startActivity(new Intent(this, Notification_reading.class));
        }
        else if (view.getId() == bt3.getId()) {
            System.out.println("bt3");
            startActivity(new Intent(this, Call_history.class));
        }
        else if (view.getId() == bt4.getId()) {
            System.out.println("bt4");
        }
        else if (view.getId() == bt5.getId()){
            System.out.println("bt5");
            startActivity(new Intent(this, Layout_above_others.class));
        }
        else if (view.getId() == bt6.getId()) {
            System.out.println("bt6");
            startActivity(new Intent(this, Call_blocking.class));
        }
        else if (view.getId() == bt7.getId()) {
            System.out.println("bt7");
        }
        else {
            System.out.println("bt8");
        }
    }

    ///admin
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE == requestCode)
        {
            if(requestCode == Activity.RESULT_OK)
            {
                //yesli chto to nuzhno delat s polucheniyem prav admina
            }
            else
            {
                // cancle it.
            }
        }
    }
    ///
}