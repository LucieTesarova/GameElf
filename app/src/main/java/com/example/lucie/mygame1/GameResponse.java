package com.example.lucie.mygame1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/*
 Trida GameResponse
 Slouzi k zaznamenani odpovedi
 */
public class GameResponse extends Activity {

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
       // dm.deleteTable();

        ano = findViewById(R.id.radiobuttonano);
        ne = findViewById(R.id.radiobuttonne);
        potvrdit = findViewById(R.id.potvrdit);

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

    public void returnActivity(String odkaz){
        returnIntent.putExtra("odkaz",odkaz);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    public void save (View v) {
        boolean b = checkFormat(odkaz);
        Toast.makeText(getApplicationContext(), "boolean " + b, Toast.LENGTH_LONG).show();
        if (!b){
            openDisplayResponse();
        }
        returnActivity(odkaz);
    }

    public boolean checkFormat(String odkaz){
        try {
          Integer.valueOf(odkaz);
          return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public void openDisplayResponse(){
        Intent intent = new Intent(getApplicationContext(), DisplayResponse.class);
        intent.putExtra("odkaz", odkaz);
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
}
