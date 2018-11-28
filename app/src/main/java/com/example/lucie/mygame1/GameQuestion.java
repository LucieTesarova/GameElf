package com.example.lucie.mygame1;

import android.app.Activity;
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

/*
 Trida GameQuestion
 Slouzi k zobrazeni otazky
 */
public class GameQuestion extends AppCompatActivity {

    private TextView otazka;
    private Button pokracuj;
    private int id = 1;
    static final int REQUEST = 1;
    DataModel dm = new DataModel(this);
    private boolean continueMusic = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamequestion);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(myToolbar);

        otazka = findViewById(R.id.otazka);
        pokracuj = findViewById(R.id.buttonPokracuj);
        Item item = dm.getItem(1);
        otazka.setText(item.getHlavniText());
        Intent i = getIntent();
        if (i.hasExtra("id")){
            id = i.getIntExtra("id", 0);
            String newId = String.valueOf(id);
            setText(newId);
            Toast.makeText(getApplicationContext(), "id doruceno", Toast.LENGTH_LONG).show();
        }

        pokracuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameResponse.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("odkaz");
                setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "chyba", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void setText(String text){
        Item item = dm.getItem(Integer.parseInt(text));
        id = item.getId();
        otazka.setText(item.getHlavniText());
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
        switch (item.getItemId()){
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
