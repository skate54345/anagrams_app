package com.austin.anagrams;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Austin on 10/16/2017.
 */

public class MusicManager implements MediaPlayer.OnPreparedListener {

    static MediaPlayer mPlayer;
    Context context;
    private int mySoundId;

    public MusicManager(Context ctx, int musicID) {
        context = ctx;
        mySoundId = musicID;
        mPlayer = MediaPlayer.create(context, mySoundId);
        mPlayer.setOnPreparedListener(this);
    }

    public void play() {
        mPlayer = MediaPlayer.create(context, mySoundId);

    }

    public void stop() {
        mPlayer.stop();
        mPlayer.release();
    }

    @Override
    public void onPrepared(MediaPlayer player) {
        player.start();
        mPlayer.setLooping(true);
        mPlayer.setVolume(100, 100);

    }

}