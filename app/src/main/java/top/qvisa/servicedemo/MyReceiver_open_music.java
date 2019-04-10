package top.qvisa.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver_open_music extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent  it = new Intent(context,MusicService.class);
        context.startService(it);
    }

}
