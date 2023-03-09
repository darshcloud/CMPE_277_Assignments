package com.example.weblinkandphonecallapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int CALL_PHONE_PERMISSION=100;
    private static final int SEND_SMS_PERMISSION=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Web Link and Phone Call Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        int callPhonePerm=ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);
        if(callPhonePerm!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CALL_PHONE},CALL_PHONE_PERMISSION);
        }
        int sendSMSPerm = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS);
        if(sendSMSPerm!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
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
    public void closeApp(View view){
    finish();
    }
    public void openBrowser(View view) {
        EditText urlEditText = (EditText) findViewById(R.id.editTextUrl);
        String url = urlEditText.getText().toString();
        if(!url.isEmpty()){
            if(!url.startsWith("http")) url="https://"+url;
            Uri targetPage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, targetPage);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Enter a URL", Toast.LENGTH_SHORT).show();
        }
    }

    public void openDialer(View view) {
        EditText urlEditText = (EditText) findViewById(R.id.editTextPhone);
        String phoneNumber = urlEditText.getText().toString();
        if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Enter a Valid Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    public void openChat(View view){
        EditText urlEditText = (EditText) findViewById(R.id.editTextPhone);
        String phoneNumber = urlEditText.getText().toString();
        EditText editText = (EditText) findViewById(R.id.editMessage);
        String message = editText.getText().toString();
        if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNumber, null));
            intent.putExtra("sms_body",message);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Please Enter a Valid Phone Number to send Text Message", Toast.LENGTH_SHORT).show();
        }
    }

}