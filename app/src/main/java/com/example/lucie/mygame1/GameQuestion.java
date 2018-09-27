package com.example.lucie.mygame1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameQuestion extends Activity {

    private TextView otazka;
    private Button pokracuj;


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
                startActivity(intent);
            }
        });

    }


}
