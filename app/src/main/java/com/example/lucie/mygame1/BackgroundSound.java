package com.example.lucie.mygame1;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundSound {

    private static MediaPlayer player;
    private static Context con;

    public static void create(Context context) {
        con = context;
        player = MediaPlayer.create(context, R.raw.music);
        player.setLooping(true);
        if (!player.isPlaying()) {
            player.start();
        }
    }

    public static void start() {
        if (player != null) {
            if (!player.isPlaying()) {
                player.start();
            }
        }
    }


    public static void pause() {
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            }
        }
    }

    public static void turnOffMusic() {
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.release();
            player = null;
        }
    }

    public static void turnOnMusic() {
        if (player == null) {
            create(con);
        }
    }
}

