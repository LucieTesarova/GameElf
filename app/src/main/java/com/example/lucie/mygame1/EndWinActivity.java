package com.example.lucie.mygame1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/*
 Trida EndWinActivity
 Spousti animaci pro vyhre
 */

public class EndWinActivity extends AppCompatActivity {

    private ImageView imageVyhra;
    private ImageView hvezda1;
    private ImageView hvezda2;
    private ImageView hvezda3;
    private ImageView hvezda4;
    private ImageView hvezda5;
    private ImageView hvezda6;
    private static MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_win);
        Toolbar myToolbar = findViewById(R.id.appbar);
        setSupportActionBar(myToolbar);

        player = MediaPlayer.create(getApplicationContext(), R.raw.tuudurt);
        player.start();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        imageVyhra = findViewById(R.id.image_vyhraljsi);
        hvezda1 = findViewById(R.id.hvezda1);
        hvezda2 = findViewById(R.id.hvezda2);
        hvezda3 = findViewById(R.id.hvezda3);
        hvezda4 = findViewById(R.id.hvezda4);
        hvezda5 = findViewById(R.id.hvezda5);
        hvezda6 = findViewById(R.id.hvezda6);
        pruhlednost.run();
    }

    Runnable pruhlednost = new Runnable() {
        @Override
        public void run() {
            hvezda1.animate().setDuration(1500)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
            hvezda2.animate().setDuration(2300)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
            hvezda3.animate().setDuration(2000)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
            hvezda4.animate().setDuration(2400)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
            hvezda5.animate().setDuration(2300)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
            hvezda6.animate().setDuration(1500)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
            imageVyhra.animate().setDuration(2700)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f)
                    .withEndAction(rotace);
        }
    };

    Runnable rotace = new Runnable() {
        @Override
        public void run() {
            hvezda1.animate().setDuration(500)
                    .setInterpolator(new AccelerateInterpolator()).rotationBy(360.0f);
            hvezda2.animate().setDuration(500)
                    .setInterpolator(new AccelerateInterpolator()).rotationBy(360.0f);
            hvezda3.animate().setDuration(500)
                    .setInterpolator(new AccelerateInterpolator()).rotationBy(360.0f);
            hvezda4.animate().setDuration(500)
                    .setInterpolator(new AccelerateInterpolator()).rotationBy(360.0f);
            hvezda5.animate().setDuration(500)
                    .setInterpolator(new AccelerateInterpolator()).rotationBy(360.0f);
            hvezda6.animate().setDuration(500)
                    .setInterpolator(new AccelerateInterpolator()).rotationBy(360.0f);
            imageVyhra.animate().setDuration(1000)
                    .setInterpolator(new AccelerateInterpolator())
                    .rotationBy(1080.0f)
                    .withEndAction(zvetseni);
        }
    };

    Runnable zvetseni = new Runnable() {
        @Override
        public void run() {
            imageVyhra.animate().setDuration(1000)
                    .setInterpolator(new AnticipateInterpolator())
                    .scaleXBy(1.0f)
                    .scaleYBy(1.0f);
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
