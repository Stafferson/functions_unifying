package com.example.functions_unifying.call_history;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.functions_unifying.R;

import java.util.List;

public class activity_call_history extends AppCompatActivity {

    ListView listView;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_history);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        listView = findViewById(R.id.list_view);

        String stringOutput = "";

        Uri uriCallLogs = Uri.parse("content://call_log/calls");
        Cursor cursorCallLogs = getContentResolver().query(uriCallLogs, null,null,null);
        cursorCallLogs.moveToFirst();
        do {
            String stringNumber = cursorCallLogs.getString(cursorCallLogs.getColumnIndexOrThrow(CallLog.Calls.NUMBER));
            String stringName = cursorCallLogs.getString(cursorCallLogs.getColumnIndexOrThrow(CallLog.Calls.CACHED_NAME));
            String stringDuration = cursorCallLogs.getString(cursorCallLogs.getColumnIndexOrThrow(CallLog.Calls.DURATION));
            String stringType = cursorCallLogs.getString(cursorCallLogs.getColumnIndexOrThrow(CallLog.Calls.TYPE));

            stringOutput = stringOutput + "Number: " + stringNumber
                    + "\nName: " + stringName
                    + "\nDuration: " + stringDuration
                    + "\n Type: " + stringType
                    + "\n\n";
            adapter.add(stringOutput);
        }while (cursorCallLogs.moveToNext());

        listView.setAdapter(adapter);
    }
}