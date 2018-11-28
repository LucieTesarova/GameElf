package com.example.lucie.mygame1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/*
 Trida GameResponse
 Slouzi k zaznamenani odpovedi
 */
public class GameResponse extends AppCompatActivity {

    private RadioButton ano;
    private RadioButton ne;
    private Button potvrdit;
    private int id;
    private Item item;
    private Intent returnIntent;
    private String odkaz;
    private boolean continueMusic = true;
    DataModel dm = new DataModel(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameresponse);
     //   dm.deleteTable();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(myToolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);


        ano = findViewById(R.id.radiobuttonano);
        ne = findViewById(R.id.radiobuttonne);
        potvrdit = findViewById(R.id.potvrdit);
        odkaz = "0";

        returnIntent = getIntent();
        id = returnIntent.getIntExtra("id", 0);
        item = dm.getItem(id);
        ano.setText(item.getOdpovedA());
        ne.setText(item.getOdpovedB());
    }

    public void onRadioButtonClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.radiobuttonano:
                if (checked) {
                    odkaz = item.getOdkazA();
                }
                break;
            case R.id.radiobuttonne:
                if (checked) {
                    odkaz = item.getOdkazB();
                }
                break;
        }
    }

    public void returnActivity(String odkaz) {
        returnIntent.putExtra("odkaz", odkaz);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    public void save(View v) {
        if (odkaz.equals("0")){
            Toast.makeText(getApplicationContext(), "Vyber jednu možnost !", Toast.LENGTH_LONG).show();
        }
        else {
            boolean b = checkFormat(odkaz);
            Toast.makeText(getApplicationContext(), "boolean " + b, Toast.LENGTH_LONG).show();
            if (!b) {
                openDisplayResponse();
            }
            returnActivity(odkaz);
        }
    }

    public boolean checkFormat(String odkaz) {
        try {
            Integer.valueOf(odkaz);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public void openDisplayResponse() {
        Intent intent = new Intent(getApplicationContext(), DisplayResponse.class);
        intent.putExtra("odkaz", odkaz);
        intent.putExtra("id", id);
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
            case android.R.id.home:
                finish();
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
