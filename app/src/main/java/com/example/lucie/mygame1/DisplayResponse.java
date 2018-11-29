package com.example.lucie.mygame1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayResponse extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private boolean continueMusic = true;
    private int id;
    private String odkaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_response);
        Toolbar myToolbar = findViewById(R.id.appbar);
        setSupportActionBar(myToolbar);

        textView = findViewById(R.id.response);
        button = findViewById(R.id.buttonPotvrdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkId()) {
                    Intent intent = new Intent(getApplicationContext(), GameQuestion.class);
                    intent.putExtra("id", ++id);
                    startActivity(intent);
                }
            }
        });

        Intent intent = getIntent();
        odkaz = intent.getStringExtra("odkaz");
        id = intent.getIntExtra("id", 0);
        //  Toast.makeText(getApplicationContext(), "id " + id, Toast.LENGTH_LONG).show();
        textView.setText(odkaz);

    }

    private boolean checkId() {
        boolean b = true;
        switch (id) {
            case 1:
                --id;
                break;
            case 4:
            case 7:
            case 8:
            case 11:
            case 12:
            case 17:
                openEndLoseActivity();
                Toast.makeText(getApplicationContext(), "Prohral jsi", Toast.LENGTH_LONG).show();
                break;
            case 9:
            case 16:
                openEndWinActivity();
                Toast.makeText(getApplicationContext(), "Vyhral jsi", Toast.LENGTH_LONG).show();
                break;
            case 19:
                if (odkaz.startsWith("s")) {
                    openEndLoseActivity();
                    Toast.makeText(getApplicationContext(), "Prohral jsi", Toast.LENGTH_LONG).show();
                } else {
                    openEndWinActivity();
                    Toast.makeText(getApplicationContext(), "Vyhral jsi", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                b = false;
        }
        return b;
    }

    public void openEndWinActivity() {
        Intent intent = new Intent(getApplicationContext(), EndWinActivity.class);
        startActivity(intent);
    }

    public void openEndLoseActivity() {
        Intent intent = new Intent(getApplicationContext(), EndLoseActivity.class);
        startActivity(intent);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int i = event.getKeyCode();
        if (i == event.KEYCODE_BACK) {
            continueMusic = false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                SoundDialogFragment dialog = new SoundDialogFragment();
                dialog.show(getSupportFragmentManager(), "dialog");
                break;
            case R.id.action_endgame:
                this.finishAffinity();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
