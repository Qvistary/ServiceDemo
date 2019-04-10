package top.qvisa.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver_close_music extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent  it = new Intent(context,MusicService.class);
        context.stopService(it);
    }
}
