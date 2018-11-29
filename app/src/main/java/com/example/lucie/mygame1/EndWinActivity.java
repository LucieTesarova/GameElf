package com.example.lucie.mygame1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

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

        Toast.makeText(getApplicationContext(), "Otevrena endWinActivity", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            pruhlednost.run();
        }
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
}
