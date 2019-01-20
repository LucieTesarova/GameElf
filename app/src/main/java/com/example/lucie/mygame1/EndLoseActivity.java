package com.example.lucie.mygame1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

/*
 Trida EndLoseActivity
 Spousti animaci pro prohre
 */

public class EndLoseActivity extends AppCompatActivity {

    private ImageView imageView;
    private static MediaPlayer player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_lose);
        Toolbar myToolbar = findViewById(R.id.appbar);
        setSupportActionBar(myToolbar);
        imageView = findViewById(R.id.image_prohraljsi);
        player = MediaPlayer.create(getApplicationContext(), R.raw.lose);
        player.start();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        rotace.run();
    }

    Runnable rotace = new Runnable() {
        @Override
        public void run() {
            imageView.animate().setDuration(1500)
                    .setInterpolator(new AccelerateInterpolator())
                    .rotationBy(1080)
                    .withEndAction(zvetseni);
        }
    };

    Runnable zvetseni = new Runnable() {
        @Override
        public void run() {
            imageView.animate().setDuration(1000)
                    .setInterpolator(new AnticipateInterpolator())
                    .scaleXBy(0.8f)
                    .scaleYBy(0.8f);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_end, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finishAffinity();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BackgroundSound.turnOffMusic();
        if (player != null && player.isPlaying()){
            player.stop();
            player.release();
            player = null;
        }
    }
}
