package com.example.lucie.mygame1;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundSound {

    private static MediaPlayer player;

    public static void create(Context context) {
        player = MediaPlayer.create(context, R.raw.music);
        player.setLooping(true);
        if (!player.isPlaying()) {
            player.start();
        }
    }

    public static void start(Context context) {
        if (!player.isPlaying()) {
            player.start();
        }
    }


    public static void pause() {
        if (player.isPlaying()) {
            player.pause();
        }
    }

    public static void release() {
        if (player.isPlaying()) {
            player.stop();
        }
        player.release();
    }
}

