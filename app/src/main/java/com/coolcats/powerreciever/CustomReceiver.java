package com.coolcats.powerreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        String toastMsg;
        if(action != null){
            switch(action) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMsg = "Power Connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMsg = "Power Disconnected";
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    toastMsg = "Plug";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    int num = intent.getIntExtra("ID", 0);
                    num *= num;
                    toastMsg = "Custom Broadcast Received\nThe square of the number is " + num;
                    break;
                default:
                    toastMsg = "Unknown message recieved";
            }
            Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show();
        }
    }
}