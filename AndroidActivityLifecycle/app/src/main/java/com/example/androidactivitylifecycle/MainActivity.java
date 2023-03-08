package com.example.androidactivitylifecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static  int threadCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        threadCounter += 1;

        String message = "Thread counter in MainActivity onRestart is: "+ String.valueOf(threadCounter);
        Log.v(TAG,message);
        TextView threadCounterText = findViewById(R.id.thread_counter_txt);
        threadCounterText.setText("ThreadCounter: " + String.valueOf(threadCounter));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onStartActivityB (View view) {
        Intent activityBIntent = new Intent(MainActivity.this, ActivityB.class);
        startActivity(activityBIntent);
    }

    public void onTriggerDialog (View view) {
        new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage("This is a Dialog!!!")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {}
                })
                .show();
    }

    public void onCloseApp (View view) {
        threadCounter = 0;
        finish();
        System.exit(0);
    }
}