package top.qvisa.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.chengdu);
        mediaPlayer.start();
        MainActivity.Update("开始播放音乐");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        MainActivity.Update("已结束播放音乐");
    }
}
