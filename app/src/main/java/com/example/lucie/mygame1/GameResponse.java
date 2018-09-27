package com.example.lucie.mygame1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    DataModel dm = new DataModel(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameresponse);
        //  dm.deleteTable();

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
        Toast.makeText(getApplicationContext(), "ulozeno", Toast.LENGTH_LONG).show();
        returnActivity(odkaz);
    }
}
