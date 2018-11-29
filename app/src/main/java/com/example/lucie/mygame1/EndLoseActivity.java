package com.example.lucie.mygame1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class EndLoseActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_lose);
        imageView = findViewById(R.id.image_prohraljsi);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        Toast.makeText(getApplicationContext(), "Otevrena endLoseActivity", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            rotace.run();
        }
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
                    .scaleXBy(1.0f)
                    .scaleYBy(1.0f);
        }
    };
}
