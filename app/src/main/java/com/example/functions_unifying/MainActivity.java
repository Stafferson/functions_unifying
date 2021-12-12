package com.example.functions_unifying;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.functions_unifying.call_history.activity_call_history;
import com.example.functions_unifying.layout_above_everything.activity_layout_above_others;
import com.example.functions_unifying.notifications_reader.activity_notification_reading;

public class MainActivity extends AppCompatActivity {

    Button b1_2, bt3, bt4, bt5, bt6, bt7, bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            startActivity(new Intent(this, activity_notification_reading.class));
        }
        else if (view.getId() == bt3.getId()) {
            System.out.println("bt3");
            startActivity(new Intent(this, activity_call_history.class));
        }
        else if (view.getId() == bt4.getId()) {
            System.out.println("bt4");
        }
        else if (view.getId() == bt5.getId()){
            System.out.println("bt5");
            startActivity(new Intent(this, activity_layout_above_others.class));
        }
        else if (view.getId() == bt6.getId()) {
            System.out.println("bt6");
        }
        else if (view.getId() == bt7.getId()) {
            System.out.println("bt7");
        }
        else {
            System.out.println("bt8");
        }
    }
}