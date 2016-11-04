package com.testing.myfirebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pusher.android.PusherAndroid;
import com.pusher.android.notifications.ManifestValidator;
import com.pusher.android.notifications.PushNotificationRegistration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PusherAndroid pusher = new PusherAndroid("e8fe5124173e43eea51a");
        PushNotificationRegistration nativePusher = pusher.nativePusher();
        try {
            nativePusher.registerFCM(this);
        } catch (ManifestValidator.InvalidManifestException e) {
            e.printStackTrace();
        }
        nativePusher.subscribe("newpost");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
