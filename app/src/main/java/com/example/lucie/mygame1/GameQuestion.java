package com.example.lucie.mygame1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameQuestion extends Activity {

    private TextView otazka;
    private Button pokracuj;
    private int id = 1;
    static final int REQUEST = 1;
    DataModel dm = new DataModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamequestion);

        otazka = findViewById(R.id.otazka);
        pokracuj = findViewById(R.id.buttonPokracuj);
        pokracuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameResponse.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, REQUEST);
            }
        });

        Item item = dm.getItem(1);
        otazka.setText(item.getHlavniText());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("odkaz");
                Toast.makeText(this, "vysledek " + result, Toast.LENGTH_LONG).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                Toast.makeText(this, "chyba", Toast.LENGTH_LONG).show();
            }
        }
    }
}
