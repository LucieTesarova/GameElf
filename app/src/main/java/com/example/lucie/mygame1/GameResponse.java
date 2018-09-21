package com.example.lucie.mygame1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RadioButton;

public class GameResponse extends Activity {

    private RadioButton ano;
    private RadioButton ne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameresponse);

        ano = findViewById(R.id.radiobuttonano);
        ne = findViewById(R.id.radiobuttonne);


    }
}
