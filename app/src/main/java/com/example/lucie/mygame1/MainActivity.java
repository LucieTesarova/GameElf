package com.example.lucie.mygame1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


/*
 Trida MainActivity
 Spousti aplikaci, zobrazuje uvodni rozcestnik hry
 */
public class MainActivity extends AppCompatActivity {

    private Button hrat;
    private Button konec;
    private Button nastaveni;
    private boolean continueMusic = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BackgroundSound.create(this);

        hrat = findViewById(R.id.buttonHrat);
        hrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameQuestion.class);
                startActivity(intent);
            }
        });

        nastaveni = findViewById(R.id.buttonNastaveni);
        nastaveni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundDialogFragment dialog = new SoundDialogFragment();
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        });

        konec = findViewById(R.id.buttonKonec);
        konec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!continueMusic) {
            BackgroundSound.pause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        continueMusic = false;
        BackgroundSound.start();
    }
}
