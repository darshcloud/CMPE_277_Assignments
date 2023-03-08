package com.example.androidactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityB extends AppCompatActivity {

    private static final String TAG = "ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        MainActivity.threadCounter++;
        String message = "Thread counter in ActivityB onRestart is: "+ String.valueOf(MainActivity.threadCounter);
        Log.v(TAG,message);
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

    public void onFinishActivityB(View view) {
        finish();
    }
}